/** Classname: CounterService 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.services;

import com.prontipagos.exam.exception.ProntipagosException;

/** 
* interface to define counter service
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
public interface CounterService {

	
	/**
	 * @param sentence
	 * @return int
	 * @throws ProntipagosException
	 */
	public int CountWords(final String sentence) throws ProntipagosException;
}
