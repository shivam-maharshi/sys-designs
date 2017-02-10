package com.lift.allocator;

import java.util.ArrayList;

import com.lift.entities.Lift;
import com.lift.request.LiftAllocationRequest;
import com.lift.util.Util;

/**
 * Closest in path allocator algorithm allocates the closest lift traveling in
 * the direction of floor from which the {@link LiftAllocationRequest} has
 * originated.
 * 
 * @author shivam.maharshi
 */
public class ClosestInPathLiftAllocator implements LiftAllocator {

  @Override
  @SuppressWarnings("unchecked")
  public Lift allocate(Object liftPool, LiftAllocationRequest request) {
    ArrayList<Lift> lifts = (ArrayList<Lift>) liftPool;
    int minDis = Integer.MAX_VALUE, start = request.getStart(), end = request.getEnd();
    boolean upDir = start - end < 0;
    Lift res = null;
    /*
     * Parses all lifts to get a static lift or closest lift moving in our
     * direction.
     */
    for (Lift lift : lifts) {
      switch (lift.getState()) {
      case IDLE:
        if (Math.abs(lift.getLevel() - start) < minDis) {
          minDis = Math.abs(lift.getLevel() - start);
          res = lift;
        }
        break;
      case MOVING_UP:
        if (lift.getLevel() < start && upDir && start - lift.getLevel() < minDis) {
          minDis = start - lift.getLevel();
          res = lift;
        }
        break;
      case MOVING_DOWN:
        if (lift.getLevel() > start && !upDir && lift.getLevel() - start < minDis) {
          minDis = lift.getLevel() - start;
          res = lift;
        }
        break;
      default:
        break;
      }
    }
    // Try the closest lift traveling in the opposite direction.
    if (res == null) {
      for (Lift lift : lifts) {
        switch (lift.getState()) {
        case MOVING_UP:
          int maxFloor = Util.getMax(lift.getQueue());
          int liftDistanceToStart = end > maxFloor ? end - lift.getLevel() : 2 * maxFloor - end - lift.getLevel();
          if (liftDistanceToStart < minDis) {
            minDis = liftDistanceToStart;
            res = lift;
          }
          break;
        case MOVING_DOWN:
          int minFloor = Util.getMin(lift.getQueue());
          liftDistanceToStart = end < minFloor ? lift.getLevel() - end : end + lift.getLevel() - 2 * minFloor;
          if (liftDistanceToStart < minDis) {
            minDis = liftDistanceToStart;
            res = lift;
          }
          break;
        default:
          break;
        }
      }
    }
    return res;
  }

}
