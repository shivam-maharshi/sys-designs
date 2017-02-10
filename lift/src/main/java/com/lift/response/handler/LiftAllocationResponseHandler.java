package com.lift.response.handler;

import com.lift.response.LiftAllocationResponse;

/**
 * Handles the response for seat allocation request. Any action to be performed
 * using {@link LiftAllocationResponse} like, sending email notifications,
 * printing tickets, sending text, etc. should be implemented here.
 * 
 * @author shivam.maharshi
 */
public class LiftAllocationResponseHandler extends BaseResponseHandler<String, LiftAllocationResponse> {

  /**
   * Receives a {@link LiftAllocationResponse} and returns its string
   * representation in the format - [REQ_ID][space][LIFT_ID].
   */
  public String dispatch(LiftAllocationResponse response) {
    return response.getLift() == null ? "All lifts are currently non functional! Please try later."
        : response.getId() + " " + response.getLift().getId();
  }

}
