package com.walmart.mts.request.handler;

import java.util.List;

import com.walmart.mts.allocator.ClusteredSeatAllocator;
import com.walmart.mts.allocator.SeatAllocator;
import com.walmart.mts.database.MovieTheaters;
import com.walmart.mts.entities.MovieTheater;
import com.walmart.mts.entities.Screen;
import com.walmart.mts.entities.Seat;
import com.walmart.mts.request.SeatAllocationRequest;
import com.walmart.mts.response.SeatAllocationResponse;

/**
 * Handles a {@link SeatAllocationRequest} and returns a
 * {@link SeatAllocationResponse} with the allocated seats information using
 * {@link ClusteredSeatAllocatorTest} strategy.
 * 
 * @author shivam.maharshi
 */
public class SeatAllocationRequestHandler extends BaseRequestHandler<SeatAllocationRequest, SeatAllocationResponse> {

  private SeatAllocator<SeatAllocationRequest> seatAllocator = new ClusteredSeatAllocator();

  /**
   * Processes an incoming {@Link SeatAllocationRequest} and returns a
   * {@link SeatAllocationResponse} with the reserved seat information. Uses
   * clustered seat algorithm for allocating seats.
   */
  public SeatAllocationResponse process(SeatAllocationRequest request) {
    MovieTheater theater = MovieTheaters.THEATERS.get(request.getTheaterId());
    Screen screen = theater.getScreen(request.getScreenId());
    List<Seat> reservedSeats = seatAllocator.allocate(screen.getSeatPool(), request);
    return new SeatAllocationResponse(request.getId(), reservedSeats, theater, screen);
  }

}
