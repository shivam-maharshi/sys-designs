package com.walmart.mts.request.handler;

import com.walmart.mts.request.Request;

/**
 * All classes handling {@link Request} must implement this interface.
 * 
 * @author shivam.maharshi
 *
 * @param <K>
 * @param <M>
 */
public interface RequestHandler<K, M> {

  /**
   * Processes an incoming requests and returns a response.
   * 
   * @param request
   *          - Incoming requests to be processed.
   * @return response - Response to an input request.
   */
  public M process(K request);

}
