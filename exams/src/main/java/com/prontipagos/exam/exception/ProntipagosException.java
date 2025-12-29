/** Classname: ProntipagosException 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.exception;

/** 
* class to define custom exception
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
public class ProntipagosException extends Exception {

	/** Class serial version UID */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @param message
	 */
	public ProntipagosException(String message){
		super(message);
	}

}
