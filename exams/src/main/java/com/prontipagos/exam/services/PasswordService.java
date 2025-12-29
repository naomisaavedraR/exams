/** Classname: PasswordService 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.services;

import com.prontipagos.exam.exception.ProntipagosException;

/** 
* interface to define password service
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
public interface PasswordService {
	
	/**
	 * @param password
	 * @return boolean
	 * @throws ProntipagosException
	 */
	public boolean isValidPassword(final String password) throws ProntipagosException;

}
