package com.lift.database;

import static com.lift.entities.LiftState.IDLE;
import static com.lift.entities.LiftType.PASSENGER;

import java.util.ArrayList;
import java.util.List;

import com.lift.entities.BasicLift;
import com.lift.entities.Lift;

/**
 * Acts as an in-memory data store for all lifts current state. In real world
 * cloud applications this data would be stored in a database.
 * 
 * @author shivam.maharshi
 */
public class Lifts {

  private static int MAX_WEIGHT = 1000;
  public static List<Lift> lifts = new ArrayList<Lift>();

  public static void setup(int floors, int totalLifts) {
    for (int i = 0; i < totalLifts; i++)
      lifts.add(new BasicLift(i + 1, 0, IDLE, PASSENGER, 0, floors, MAX_WEIGHT));
  }

}
