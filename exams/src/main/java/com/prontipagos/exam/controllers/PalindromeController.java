package com.prontipagos.exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.response.ResponseItem;
import com.prontipagos.exam.services.PalindromeService;

@RequestMapping("v1/palindrome")
@RestController
public class PalindromeController {

	@Autowired
	private PalindromeService palindromeService;

	@GetMapping
	public ResponseEntity<ResponseItem<Boolean>> validatePalindrome(@RequestParam String word) {

		int code = 0;
		String message = "error";
		Boolean value = false;
		try {
			value = palindromeService.isPalindrome(word);
			message ="success";
		} catch (ProntipagosException e) {
			code = -1;
			message = e.getMessage();
		} catch (Exception e) {
			code = -100;
			message = e.getMessage();
		}
		ResponseItem<Boolean> response = new ResponseItem<>(message, code, value);
		return ResponseEntity.ok(response);
	}
}
