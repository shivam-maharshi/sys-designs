package com.walmart.mts.response;

/**
 * All {@link Response} objects can extend this to reuse fields. Holds ID since
 * all responses must have an identifier field.
 * 
 * @author shivam.maharshi
 *
 * @param <T>
 */
public abstract class BaseResponse<T> implements Response<T> {

  protected T id;

  public T getId() {
    return id;
  }

}
