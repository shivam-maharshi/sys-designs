package com.lift.service;

import com.lift.database.Lifts;
import com.lift.entities.Lift;

/**
 * These services are responsible for maintaining the system state and
 * controlling the lift system centrally. It is the single point of access for
 * the state of all the lifts in the system.
 * 
 * @author shivam.maharshi
 */
public class LiftAdminService {

  public boolean close(int id) {
    if (id < 1 || id > Lifts.lifts.size())
      throw new RuntimeException("Invalid lift id! Please pass a valid value.");
    Lift lift = Lifts.lifts.get(id - 1);
    return lift.close();
  }

  public boolean open(int id) {
    if (id < 1 || id > Lifts.lifts.size())
      throw new RuntimeException("Invalid lift id! Please pass a valid value.");
    Lift lift = Lifts.lifts.get(id - 1);
    return lift.open();
  }

  public boolean move(int id, int end) {
    if (id < 1 || id > Lifts.lifts.size())
      throw new RuntimeException("Invalid lift id! Please pass a valid value.");
    Lift lift = Lifts.lifts.get(id - 1);
    if (end < lift.getMinLevel() || end > lift.getMaxLevel())
      throw new RuntimeException(String
          .format("Invalid floor! Please pass a valid value in range [%d, %d]", lift.getMinLevel(), lift.getMaxLevel())
          .toString());
    lift.close();
    return lift.move();
  }

}
