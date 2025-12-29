package com.prontipagos.exam.services.impl;

import org.springframework.stereotype.Service;

import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.services.CounterService;

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
