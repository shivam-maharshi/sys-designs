package com.lift.request;

/**
 * Represents a request for a lift allocation. In simple words means an end user
 * needs to use the lift.
 * 
 * @author shivam.maharshi
 */
public class LiftAllocationRequest extends BaseRequest<String> {

  private int start;
  private int end;

  public LiftAllocationRequest(String id, int start, int end) {
    super();
    this.id = id;
    this.start = start;
    this.end = end;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

}
