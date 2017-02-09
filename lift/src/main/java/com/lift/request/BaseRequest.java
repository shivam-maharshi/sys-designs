package com.lift.request;

/**
 * All objects representing a request should extend this to reuse fields. Every
 * request must have an identifier.
 * 
 * @author shivam.maharshi
 * 
 * @param <T>
 */
public abstract class BaseRequest<T> implements Request<T> {

  protected T id;

  public T getId() {
    return id;
  }

}
