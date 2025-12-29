/** Classname: CounterServiceImpl 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.services.impl;

import org.springframework.stereotype.Service;

import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.services.CounterService;

/** 
* class to define counter service
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
@Service
public class CounterServiceImpl implements CounterService {

	@Override
	public int CountWords(String sentence) throws ProntipagosException {

		if (sentence == null || sentence.trim().isEmpty()) {
			throw new ProntipagosException("cadena vacia");
		}
		String[] parts = sentence.trim().split("\\s+");
		return parts.length;
	}

}
