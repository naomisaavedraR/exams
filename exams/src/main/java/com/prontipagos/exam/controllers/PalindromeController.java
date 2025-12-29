package com.prontipagos.exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.response.ResponseItem;
import com.prontipagos.exam.services.PalindromeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("v1/palindrome")
@RestController
@Tag(name = "Palindrome Controller", description = "controller to validate a palindrome's word")
public class PalindromeController {

	@Autowired
	private PalindromeService palindromeService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "ejecute a validation of a word", description = "validate if a word is a palindrome")
	@ApiResponse(responseCode = "200", description = "success, the response is encapsulated in a response item",
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
					schema = @Schema(implementation = Boolean.class), examples = @ExampleObject(name = "valid response",
							summary = "valid response of a palyndrome", value = """
									{
									      "code": 0,
										  "message": "success",
										  "payload": true
									}
									""")))
	public ResponseEntity<ResponseItem<Boolean>> validatePalindrome(
			@Parameter(description = "word to validate", example = "ana", required = true) @RequestParam String word) {

		int code = 0;
		String message = "error";
		Boolean value = false;
		try {
			value = palindromeService.isPalindrome(word);
			message = "success";
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
