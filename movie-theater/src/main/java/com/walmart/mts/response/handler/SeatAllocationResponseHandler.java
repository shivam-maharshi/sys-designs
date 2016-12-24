package com.walmart.mts.response.handler;

import com.walmart.mts.entities.SeatPool;
import com.walmart.mts.response.SeatAllocationResponse;

/**
 * Handles the response for seat allocation request. Any action to be performed
 * using {@link SeatAllocationResponse} like, sending email notifications,
 * printing tickets, sending text, etc. should be implemented here.
 * 
 * @author shivam.maharshi
 */
public class SeatAllocationResponseHandler extends BaseResponseHandler<String, SeatAllocationResponse> {

  /**
   * Receives a {@link SeatAllocationResponse} and returns its string
   * representation in the format - [REQ_ID][space][LIST_OF_SEAT_IDENTIFIERS].
   */
  public String dispatch(SeatAllocationResponse response) {
    if (response.getAllocatedSeats() == null) {
      SeatPool sp = response.getScreen().getSeatPool();
      return "Insufficient seats! Only " + (sp.maximumCapacity() - sp.size()) + " seats are left in "
          + response.getScreen().getName();
    }
    StringBuilder sb = new StringBuilder();
    sb.append(response.getId() + " ");
    for (int i = 0; i < response.getAllocatedSeats().size(); i++) {
      sb.append(response.getAllocatedSeats().get(i).getId());
      if (i < response.getAllocatedSeats().size() - 1)
        sb.append(", ");
    }
    return sb.toString();
  }

}
