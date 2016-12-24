package com.walmart.mts.request;

/**
 * An instance of this class represents a request for seat allocation.
 * 
 * @author shivam.maharshi
 */
public class SeatAllocationRequest extends BaseRequest<String> {

  private int seatsRequested;
  private int screenId;
  private int theaterId;

  public SeatAllocationRequest(String id, int seats, int screenId, int theaterId) {
    this.id = id;
    this.seatsRequested = seats;
    this.screenId = screenId;
    this.theaterId = theaterId;
  }

  public int getSeatsRequested() {
    return seatsRequested;
  }

  public int getScreenId() {
    return screenId;
  }

  public int getTheaterId() {
    return theaterId;
  }

}
