package com.walmart.mts.allocator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.walmart.mts.entities.EntityPool;
import com.walmart.mts.entities.Screen;
import com.walmart.mts.entities.Seat;
import com.walmart.mts.entities.SeatRow;
import com.walmart.mts.entities.TabularEntityPool;
import com.walmart.mts.request.SeatAllocationRequest;

/**
 * Clustered seat allocation algorithm which allocates free seats in the close
 * vicinity for a single {@link SeatAllocationRequest}.
 * 
 * @author shivam.maharshi
 */
public class ClusteredSeatAllocator implements SeatAllocator<SeatAllocationRequest> {

  /**
   * The algorithm works the following way:<br>
   * 1. Requested seats are allocated adjacently in a row with maximum number of
   * free seats.<br>
   * 
   * 2. If the number of seats requested are more than the free seats available
   * in a single row with maximum free seats, than all the free seats from this
   * row are allocated to this requests and the remaining seats are allocated
   * from the next row with the second highest number of free seats available.
   * This process goes on till the request is full-filled.<br>
   * 
   * 3. If the number of seats requested are more than the total number of free
   * seats available in the {@link Screen}, than an empty list of {@link Seat}
   * is returned.<br>
   * 
   * Every time seat allocation takes place, rows in the {@link EntityPool} are
   * sorted in the descending order of the free seats available.<br>
   * 
   * Run-time complexity is O(nLog(n) + m) where n & m are the number of rows &
   * columns respectively in the {@link TabularEntityPool}.
   */
  @SuppressWarnings("unchecked")
  public List<Seat> allocate(EntityPool<Seat> ep, SeatAllocationRequest sar) {
    List<Seat> allocatedSeats = null;
    TabularEntityPool<Seat> tep = (TabularEntityPool<Seat>) ep;
    List<SeatRow> seats = (List<SeatRow>) tep.getPool();

    // Only continue if requested seats are available.
    if (tep.maximumCapacity() - tep.size() >= sar.getSeatsRequested()) {
      allocatedSeats = new ArrayList<Seat>();
      int sr = sar.getSeatsRequested(), row = 0, col = 0;
      while (sr > 0) {
        SeatRow seatRow = seats.get(row);
        col = seatRow.getSeats().size();
        Seat seat = new Seat(seatRow.getId() + col, sar.getId(), null);
        tep.allocate(row, col, seat);
        allocatedSeats.add(seat);
        col++;
        if (col >= tep.getTotalCols())
          row++;
        sr--;
      }
      try {
        Collections.sort(seats, new SeatListComparator());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return allocatedSeats;
  }

  class SeatListComparator implements Comparator<SeatRow> {

    /**
     * List is sorted in reverse order of the nested list size. Hence the first
     * element of the list will hold the smallest list and the last will hold
     * the largest list. If two rows have the same number of free seats than the
     * one that is in the front will get filled first. This brings people of the
     * same reservation separated by rows close to each other by giving them
     * seats as close to the each other as possible.
     */
    public int compare(SeatRow o1, SeatRow o2) {
      if (o1.getSeats().size() < o2.getSeats().size())
        return -1;
      else if (o1.getSeats().size() > o2.getSeats().size())
        return 1;
      else {
        return o1.getId().compareTo(o2.getId());
      }
    }

  }

}
