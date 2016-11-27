package com.walmart.mts.response.handler;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.walmart.mts.database.MovieTheaters;
import com.walmart.mts.entities.MovieTheater;
import com.walmart.mts.entities.Seat;
import com.walmart.mts.response.SeatAllocationResponse;

import junit.framework.TestCase;

/**
 * Test cases for {@link SeatAllocationResponseHandler}.
 * 
 * @author shivam.maharshi
 */
public class SeatAllocationResponseHandlerTest extends TestCase {

  @Test
  public void testSuccessfulDispatchReturnsStringOfReservationIdAndCommaSeperatedSeatListId() {
    MovieTheaters.setup(10, 10);
    MovieTheater mt = MovieTheaters.THEATERS.get(1);
    List<Seat> seats = new ArrayList<>();
    seats.add(new Seat("A0"));
    seats.add(new Seat("A1"));
    seats.add(new Seat("A2"));
    SeatAllocationResponse sar = new SeatAllocationResponse("R001", seats, mt, mt.getScreen(1));
    SeatAllocationResponseHandler sah = new SeatAllocationResponseHandler();
    assertEquals("R001 A0, A1, A2", sah.dispatch(sar));
  }

  @Test
  public void testAllocationFailureReturnsInsufficientSeatsMessage() {
    MovieTheaters.setup(2, 1);
    MovieTheater mt = MovieTheaters.THEATERS.get(1);
    SeatAllocationResponse sar = new SeatAllocationResponse("R001", null, mt, mt.getScreen(1));
    SeatAllocationResponseHandler sah = new SeatAllocationResponseHandler();
    assertEquals("Insufficient seats! Only 2 seats are left in Screen 1", sah.dispatch(sar));
  }

}
