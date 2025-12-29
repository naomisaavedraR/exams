package com.prontipagos.exam.services;

import com.prontipagos.exam.exception.ProntipagosException;

public interface ThreadSafeService {

	public long validateSafeThreads(final long cycles) throws ProntipagosException;

}
