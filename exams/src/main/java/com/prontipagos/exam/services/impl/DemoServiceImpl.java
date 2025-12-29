package com.prontipagos.exam.services.impl;

import org.springframework.stereotype.Service;

import com.prontipagos.exam.dto.DemoTO;
import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.services.DemoService;

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
