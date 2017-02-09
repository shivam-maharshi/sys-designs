package com.lift.request.handler;

import com.lift.allocator.ClosestInPathLiftAllocator;
import com.lift.database.Lifts;
import com.lift.request.LiftAllocationRequest;
import com.lift.response.LiftAllocationResponse;

/**
 * Handles a {@link LiftAllocationRequest} and returns a
 * {@link LiftAllocationResponse} with the allocated lift information using
 * {@link ClusteredSeatAllocatorTest} strategy.
 * 
 * @author shivam.maharshi
 */
public class LiftAllocationRequestHandler extends BaseRequestHandler<LiftAllocationRequest, LiftAllocationResponse> {

  private ClosestInPathLiftAllocator liftAllocator = new ClosestInPathLiftAllocator();

  /**
   * Processes an incoming {@Link LiftAllocationRequest} and returns a
   * {@link LiftAllocationResponse} with the reserved lift information. Uses
   * closest in path lift algorithm for allocating lift.
   */
  public LiftAllocationResponse process(LiftAllocationRequest request) {
    return new LiftAllocationResponse(request.getId(), liftAllocator.allocate(Lifts.lifts, request).getId());
  }

}
