package com.prontipagos.exam.services.impl;

import org.springframework.stereotype.Service;

import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.services.PalindromeService;

@Service
public class PalindromeServiceImpl implements PalindromeService {

	@Override
	public boolean isPalindrome(String word) throws ProntipagosException {

		if (word == null || word.trim().isEmpty()) {
			throw new ProntipagosException("cadena vacia");
		}

		if (word.trim().split("\\s+").length > 1) {
			throw new ProntipagosException("Solo se permite 1 palabra");

		}
		String clean = word.trim();
		for (int i = 0; i < clean.length()/2; i++) {
			if (clean.charAt(i) != clean.charAt(clean.length() - 1 - i)) {
				throw new ProntipagosException("No es palindromo");
			}
		}

		return true;
	}

}
