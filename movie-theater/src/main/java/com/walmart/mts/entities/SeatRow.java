package com.walmart.mts.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a row of {@link Seat} in a {@link Screen}.
 * 
 * @author shivam.maharshi
 */
public class SeatRow extends BaseEntity<String> {

  private List<Seat> seats;

  public SeatRow(String id) {
    this.id = id;
    this.seats = new ArrayList<Seat>();
  }

  public List<Seat> getSeats() {
    return seats;
  }

}
