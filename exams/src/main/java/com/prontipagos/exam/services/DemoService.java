/** Classname: DemoService 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.services;

import com.prontipagos.exam.dto.DemoTO;
import com.prontipagos.exam.exception.ProntipagosException;

/** 
* interface to define demo service
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
public interface DemoService {
	
	
	/**
	 * @param request
	 * @return DemoTO
	 * @throws ProntipagosException
	 */
	public DemoTO knowIfitsAPlatypus(final DemoTO request) throws ProntipagosException;

}
