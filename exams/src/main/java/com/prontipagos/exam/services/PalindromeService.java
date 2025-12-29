/** Classname: PalindromeService 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.services;

import com.prontipagos.exam.exception.ProntipagosException;

/** 
* interface to define palindrome service
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
public interface PalindromeService {
	
	/**
	 * @param word
	 * @return boolean
	 * @throws ProntipagosException
	 */
	public boolean isPalindrome(final String word) throws ProntipagosException;

}
