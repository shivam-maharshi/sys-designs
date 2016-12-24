package com.walmart.mts.entities;

/**
 * Represents a screen in a {@link MovieTheater}.
 * 
 * @author shivam.maharshi
 */
public class Screen extends BaseEntity<Integer> {

  private String name;
  // All screens have a collection of {@link Seats}.
  private SeatPool seatPool;

  public Screen(int id, String name, int rows, int cols) {
    this.id = id;
    this.name = name;
    this.seatPool = new SeatPool(rows, cols);
  }

  public String getName() {
    return name;
  }

  public SeatPool getSeatPool() {
    return seatPool;
  }

}
