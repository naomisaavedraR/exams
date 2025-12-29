package com.prontipagos.exam.services;

import com.prontipagos.exam.dto.DemoTO;
import com.prontipagos.exam.exception.ProntipagosException;

public interface DemoService {
	
	
	public DemoTO knowIfitsAPlatypus(final DemoTO request) throws ProntipagosException;

}
