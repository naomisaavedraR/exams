package com.prontipagos.exam.services.impl;

import org.springframework.stereotype.Service;

import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.services.PasswordService;

@Service
public class PasswordServiceImpl implements PasswordService {

	@Override
	public boolean isValidPassword(String password) throws ProntipagosException {
		if (password == null || password.trim().isEmpty()) {
			throw new ProntipagosException("cadena vacia");
		}
		if (password.length() < 10) {
			throw new ProntipagosException("Longitud invalida");
		}
		if (!password.matches(".*[A-Z].*")) {
			throw new ProntipagosException("Sin mayuscula");

		}
		if (!password.matches(".*[a-z].*")) {
			throw new ProntipagosException("Sin minuscula");

		}
		if (!password.matches(".*[*+@].*")) {
			throw new ProntipagosException("sin caracteres especiales");
		}
		return true;
	}

}
