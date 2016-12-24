package com.walmart.mts.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a movie theater.
 * 
 * @author shivam.maharshi
 */
public class MovieTheater extends BaseEntity<Integer> {

  private String name;
  private String address;
  // Movie theater has multiple screen.
  private Map<Integer, Screen> screens;

  public MovieTheater(Integer id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.screens = new HashMap<Integer, Screen>();
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public void addScreen(Screen screen) {
    screens.put(screen.id, screen);
  }

  public Screen getScreen(Integer screenId) {
    return screens.get(screenId);
  }

  public int getScreenCounts() {
    return screens.size();
  }

}
