package com.walmart.mts.allocator;

import java.util.List;

import org.junit.Test;

import com.walmart.mts.entities.Seat;
import com.walmart.mts.entities.SeatPool;
import com.walmart.mts.request.SeatAllocationRequest;

import junit.framework.TestCase;

/**
 * Test cases for {@link ClusteredSeatAllocator}.
 * 
 * @author shivam.maharshi
 */
public class ClusteredSeatAllocatorTest extends TestCase {

	@Test
	public void testSuccessfulAllocateReturnsSeatsWithUpdatedValues() {
		SeatPool sp = new SeatPool(10, 2);
		SeatAllocationRequest sar = new SeatAllocationRequest("R001", 3, 1, 1);
		List<Seat> l = new ClusteredSeatAllocator().allocate(sp, sar);
		assertEquals(3, l.size());
		assertEquals("A0", l.get(0).getId());
		assertEquals("R001", l.get(0).getReservationId());
		assertEquals("A1", l.get(1).getId());
		assertEquals("R001", l.get(1).getReservationId());
		assertEquals("B0", l.get(2).getId());
		assertEquals("R001", l.get(2).getReservationId());
	}

}
