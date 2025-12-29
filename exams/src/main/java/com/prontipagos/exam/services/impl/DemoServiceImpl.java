/** Classname: DemoServiceImpl 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.services.impl;

import org.springframework.stereotype.Service;

import com.prontipagos.exam.dto.DemoTO;
import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.services.DemoService;

/** 
* class to define demo service
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public DemoTO knowIfitsAPlatypus(DemoTO request) throws ProntipagosException {
		if (request == null) {
			throw new ProntipagosException("dato inválido");
		}
		return request.findSound();
	}

}
