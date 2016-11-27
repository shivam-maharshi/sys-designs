package com.walmart.mts.database;

import java.util.HashMap;
import java.util.Map;

import com.walmart.mts.entities.MovieTheater;
import com.walmart.mts.entities.Screen;

/**
 * Acts as an in-memory data store for all movie theater information. In real
 * world cloud applications this data would be stored in a database.
 * 
 * @author shivam.maharshi
 */
public class MovieTheaters {

  private static final int SCREEN_ID = 1;
  private static final String SCREEN_NAME = "Screen 1";
  private static final int THEATER_ID = 1;
  private static final String THEATER_NAME = "INOX BIG Cinnema";
  private static final String THEATER_ADDRESS = "5th Avenue, New York - 10001";
  public static Map<Integer, MovieTheater> THEATERS = new HashMap<Integer, MovieTheater>();

  /**
   * Populates an in-memory representation of a collection of
   * {@link MovieTheater} objects.
   * 
   * @param rows
   *          - Maximum number of rows in the {@link Screen}.
   * @param cols
   *          - Maximum number of columns in the {@link Screen}.
   */
  public static void setup(int rows, int cols) {
    Screen screen = new Screen(SCREEN_ID, SCREEN_NAME, rows, cols);
    MovieTheater theater = new MovieTheater(THEATER_ID, THEATER_NAME, THEATER_ADDRESS);
    theater.addScreen(screen);
    THEATERS.put(THEATER_ID, theater);
  }

}
