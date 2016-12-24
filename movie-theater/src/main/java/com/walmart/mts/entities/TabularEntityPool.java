package com.walmart.mts.entities;

/**
 * Represents a table/matrix type of {@link EntityPool} which stores data as a
 * matrix.
 * 
 * @author shivam.maharshi
 *
 * @param <K>
 */
public interface TabularEntityPool<K> extends EntityPool<K> {

  /**
   * Returns the maximum number of rows available.
   * 
   * @return cows - Maximum number of rows in the pool.
   */
  public int getTotalRows();

  /**
   * Returns the maximum number of columns in the pool.
   * 
   * @return columns - Maximum number of columns in the pool.
   */
  public int getTotalCols();

  /**
   * Allocates the given row and column position to the input entity.
   * 
   * @param row
   *          - Row at which an {@link Entity} is to be placed.
   * @param col
   *          - Column at which an {@link Entity} is to be placed.
   * @param entity
   *          - The {@link Entity} to be placed at the given row and column.
   */
  public void allocate(int row, int col, K entity);

}
