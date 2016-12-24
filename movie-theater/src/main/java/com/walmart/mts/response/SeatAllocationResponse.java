package com.walmart.mts.response;

import java.util.List;

import com.walmart.mts.entities.MovieTheater;
import com.walmart.mts.entities.Screen;
import com.walmart.mts.entities.Seat;
import com.walmart.mts.request.SeatAllocationRequest;

/**
 * An instance of this class will be generated as a response for
 * {@link SeatAllocationRequest}.
 * 
 * @author shivam.maharshi
 */
public class SeatAllocationResponse extends BaseResponse<String> {

  private List<Seat> allocatedSeats;
  private MovieTheater theater;
  private Screen screen;

  public SeatAllocationResponse(String id, List<Seat> seats, MovieTheater theater, Screen screen) {
    this.id = id;
    this.allocatedSeats = seats;
    this.theater = theater;
    this.screen = screen;
  }

  public List<Seat> getAllocatedSeats() {
    return allocatedSeats;
  }

  public MovieTheater getTheater() {
    return theater;
  }

  public Screen getScreen() {
    return screen;
  }

}
