package com.lift.request;

/**
 * Represents a request for a lift allocation. In simple words means an end user
 * needs to use the lift.
 * 
 * @author shivam.maharshi
 */
public class LiftAllocationRequest extends BaseRequest<String> {

  private int from;
  private int to;

  public LiftAllocationRequest(String id, int from, int to) {
    super();
    this.id = id;
    this.from = from;
    this.to = to;
  }

  public int getFrom() {
    return from;
  }

  public void setFrom(int from) {
    this.from = from;
  }

  public int getTo() {
    return to;
  }

  public void setTo(int to) {
    this.to = to;
  }

}
