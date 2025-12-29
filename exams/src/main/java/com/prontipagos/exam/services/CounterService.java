package com.prontipagos.exam.services;

import com.prontipagos.exam.exception.ProntipagosException;

public interface CounterService {

	
	public int CountWords(final String sentence) throws ProntipagosException;
}
