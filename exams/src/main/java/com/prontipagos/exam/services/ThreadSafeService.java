/** Classname: ThreadSafeService 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.services;

import com.prontipagos.exam.exception.ProntipagosException;

/** 
* interface to define thread service
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
public interface ThreadSafeService {

	/**
	 * @param cycles
	 * @return long
	 * @throws ProntipagosException
	 */
	public long validateSafeThreads(final long cycles) throws ProntipagosException;

}
