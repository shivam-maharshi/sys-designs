package com.lift.entities;

/**
 * All entity must implement this interface. An entity in the context of this
 * project is defined as a tangible asset.
 * 
 * @author shivam.maharshi
 *
 * @param <K>
 */
public interface Entity<K> {

  public K getId();

}
