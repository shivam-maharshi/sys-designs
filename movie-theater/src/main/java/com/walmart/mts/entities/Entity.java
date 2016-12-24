package com.walmart.mts.entities;

/**
 * All objects representing an entity must implement this interface. An entity
 * in the context of this project is defined as any object that represents a
 * tangible commodity like a {@link Seat}, {@link Screen}, etc.
 * 
 * @author shivam.maharshi
 *
 * @param <K>
 */
public interface Entity<K> {

  /**
   * All entity type of objects must have a unique identifier.
   * 
   * @return ID - Unique identifier of an {@link Entity}.
   */
  public K getId();

}
