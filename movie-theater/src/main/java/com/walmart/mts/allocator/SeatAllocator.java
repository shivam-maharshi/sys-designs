package com.walmart.mts.allocator;

import com.walmart.mts.entities.Entity;
import com.walmart.mts.entities.EntityPool;
import com.walmart.mts.entities.Seat;

/**
 * All allocation strategies that allocate {@link Seat} type of {@link Entity}
 * from an {@link EntityPool} must implement this interface.
 * 
 * @author shivam.maharshi
 */
public interface SeatAllocator<M> extends EntityAllocator<Seat, M> {

}
