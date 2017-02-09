package com.lift.response;

import com.lift.request.LiftAllocationRequest;

/**
 * Represents an allocation response to a {@link LiftAllocationRequest}.
 * 
 * @author shivam.maharshi
 */
public class LiftAllocationResponse extends BaseResponse<String> {

  private Integer liftId;

  public LiftAllocationResponse(String id, Integer liftId) {
    super();
    this.id = id;
    this.liftId = liftId;
  }

  public Integer getLiftId() {
    return liftId;
  }

  public void setLiftId(Integer liftId) {
    this.liftId = liftId;
  }

}
