package com.walmart.mts.entities;

/**
 * Represents a seat in a {@link Screen}.
 * 
 * @author shivam.maharshi
 */
public class Seat extends BaseEntity<String> {

  private SeatType type;
  private String reservationId;

  public Seat(String id) {
    this(id, null, SeatType.REGULAR);
  }

  public Seat(String id, String resId) {
    this(id, resId, SeatType.REGULAR);
  }

  public Seat(String id, String resId, SeatType type) {
    super();
    this.id = id;
    this.reservationId = resId;
    this.type = type;
  }

  public SeatType getType() {
    return type;
  }

  public void setType(SeatType type) {
    this.type = type;
  }

  public String getReservationId() {
    return reservationId;
  }

  public void setReservationId(String reservationId) {
    this.reservationId = reservationId;
  }

}
