package com.walmart.mts.request.handler;

import org.junit.Test;

import com.walmart.mts.database.MovieTheaters;
import com.walmart.mts.request.SeatAllocationRequest;
import com.walmart.mts.response.SeatAllocationResponse;

import junit.framework.TestCase;

/**
 * Test cases for {@link SeatAllocationRequestHandler}.
 * 
 * @author shivam.maharshi
 */
public class SeatAllocationRequestHandlerTest extends TestCase {

  @Test
  public void testSuccessfulProcessCallReturnsCorrectResponse() {
    MovieTheaters.setup(10, 10);
    SeatAllocationRequestHandler sah = new SeatAllocationRequestHandler();
    SeatAllocationResponse sar = sah.process(new SeatAllocationRequest("R001", 3, 1, 1));
    assertEquals("R001", sar.getId());
    assertEquals(1, sar.getScreen().getId().intValue());
    assertEquals(1, sar.getTheater().getId().intValue());
    assertEquals(3, sar.getAllocatedSeats().size());
    assertEquals("A0", sar.getAllocatedSeats().get(0).getId());
    assertEquals("R001", sar.getAllocatedSeats().get(0).getReservationId());
    assertEquals("A1", sar.getAllocatedSeats().get(1).getId());
    assertEquals("R001", sar.getAllocatedSeats().get(1).getReservationId());
    assertEquals("A2", sar.getAllocatedSeats().get(2).getId());
    assertEquals("R001", sar.getAllocatedSeats().get(2).getReservationId());
  }

}
