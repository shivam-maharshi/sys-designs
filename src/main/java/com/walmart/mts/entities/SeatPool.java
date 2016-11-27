package com.walmart.mts.entities;

import java.util.ArrayList;
import java.util.List;

import com.walmart.mts.util.Util;

/**
 * Represents a pool of {@link Seat} entity. Every {@link Screen} would have one
 * such pool.
 * 
 * @author shivam.maharshi
 */
public class SeatPool implements TabularEntityPool<Seat> {

  private List<SeatRow> seats;
  private int maxRows;
  private int maxCols;
  private int size;

  public SeatPool(int rows, int cols) {
    this.seats = new ArrayList<SeatRow>();
    for (int i = 0; i < rows; i++) {
      seats.add(new SeatRow(Util.getAlphabeticalValue(i)));
    }
    this.maxRows = rows;
    this.maxCols = cols;
    this.size = 0;
  }

  public Seat get(Object... obj) {
    Integer row = (Integer) obj[0];
    Integer col = (Integer) obj[1];

    if (row < 0 || row >= seats.size())
      throw new RuntimeException("Invalid input row. Row must be greater than 0 and less than " + seats.size());
    if (col < 0 || col >= seats.get(row).getSeats().size())
      throw new RuntimeException("");

    return seats.get(row).getSeats().get(col);
  }

  public List<SeatRow> getPool() {
    return seats;
  }

  public int getTotalRows() {
    return maxRows;
  }

  public int getTotalCols() {
    return maxCols;
  }

  public int size() {
    return size;
  }

  public int maximumCapacity() {
    return maxCols * maxRows;
  }

  public void updateSize(int size) {
    this.size = size;
  }

  /**
   * Always add to the end of the given row list for this implementation.
   */
  public void allocate(int row, int col, Seat entity) {
    this.size++;
    seats.get(row).getSeats().add(entity);
  }

}
