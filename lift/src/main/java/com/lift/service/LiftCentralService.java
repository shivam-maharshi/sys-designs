package com.lift.service;

import com.lift.entities.Lift;

/**
 * These services are responsible for maintaining the system state and
 * controlling the lift system centrally. It is the single point of access for
 * the state of all the lifts in the system.
 * 
 * @author shivam.maharshi
 */
public class LiftCentralService {

  public boolean serveRequest(Lift lift, int start) {
    lift.getQueue().add(start);
    if (!lift.isOverloaded())
      throw new RuntimeException("Lift is overloaded.");
    lift.close();
    lift.move();
    return true;
  }

}
