package com.prontipagos.exam.services;

import com.prontipagos.exam.exception.ProntipagosException;

public interface PasswordService {
	
	public boolean isValidPassword(final String password) throws ProntipagosException;

}
