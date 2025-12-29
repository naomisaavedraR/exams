/** Classname: PasswordController 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
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
import com.prontipagos.exam.services.PasswordService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/** 
* class to define password controller
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
@RequestMapping("v1/password")
@RestController
@Tag(name = "Password Controller", description = "controller to validate a password")
public class PasswordController {

	/**
	 * PasswordService passwordService
	 */
	@Autowired
	private PasswordService passwordService;

	/**
	 * @param password
	 * @return  ResponseEntity<ResponseItem<Boolean>>
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "ejecute a validation of a password",
	description = "validate if a password fulfill various conditions")
	@ApiResponse(responseCode = "200",
		description = "success, the response is encapsulated in a response item",
		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
				schema = @Schema(implementation = Boolean.class), examples = @ExampleObject(name = "valid response",
						summary = "valdi response of a valid password", value = """
								{
								      "code": 0,
									  "message": "success",
									  "payload": true
								}
								""")
	
		)
	)
	public ResponseEntity<ResponseItem<Boolean>> validatePassword(
			@Parameter(description = "password to validate", example = "123abcABC***", required = true)
			@RequestParam String password) {

		int code = 0;
		String message = "error";
		Boolean value = false;
		try {
			value = passwordService.isValidPassword(password);
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
