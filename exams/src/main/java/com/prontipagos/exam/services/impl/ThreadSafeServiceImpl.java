/** Classname: ThreadSafeServiceImpl 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.services.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.services.ThreadSafeService;

/** 
* class to define thread service
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
@Service
public class ThreadSafeServiceImpl implements ThreadSafeService {

	@Override
	public long validateSafeThreads(long cycles) throws ProntipagosException {

		if (cycles <= 0) {
			throw new ProntipagosException("cycles debe ser mayor a 0");
		}
		if (cycles > Integer.MAX_VALUE) {
			throw new ProntipagosException("cycles demasiado grande");
		}

		AtomicLong value = new AtomicLong(0L);
		ExecutorService executor = Executors.newFixedThreadPool(2);

		try {
			var f1 = executor.submit(() -> {
				for (int i = 0; i < 1000; i++) {
					value.incrementAndGet();
				}
			});
			var f2 = executor.submit(() -> {
				for (int i = 0; i < 1000; i++) {
					value.decrementAndGet();
				}
			});
			f1.get();
			f2.get();

			return value.get();

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new ProntipagosException("Ejecución interrumpida");
		} catch (java.util.concurrent.ExecutionException e) {
			throw new ProntipagosException("Error en ejecución de tareas");
		} finally {
			executor.shutdown();
		}

	}

}
