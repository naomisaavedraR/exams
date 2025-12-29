/** Classname: PalindromeServiceImpl 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.services.impl;

import org.springframework.stereotype.Service;

import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.services.PalindromeService;

/** 
* class to define palindrome service
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
@Service
public class PalindromeServiceImpl implements PalindromeService {

	@Override
	public boolean isPalindrome(String word) throws ProntipagosException {

		if (word == null || word.trim().isEmpty()) {
			throw new ProntipagosException("cadena vacia");
		}

		if (word.trim().split("\\s+").length > 1) {
			throw new ProntipagosException("Solo se permite 1 palabra");

		}
		String clean = word.trim();
		for (int i = 0; i < clean.length()/2; i++) {
			if (clean.charAt(i) != clean.charAt(clean.length() - 1 - i)) {
				throw new ProntipagosException("No es palindromo");
			}
		}

		return true;
	}

}
