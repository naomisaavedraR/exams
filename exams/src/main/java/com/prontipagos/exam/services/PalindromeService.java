package com.prontipagos.exam.services;

import com.prontipagos.exam.exception.ProntipagosException;

public interface PalindromeService {
	
	public boolean isPalindrome(final String word) throws ProntipagosException;

}
