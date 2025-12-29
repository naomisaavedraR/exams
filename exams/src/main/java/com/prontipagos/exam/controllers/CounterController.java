/** Classname: CounterController 
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
import com.prontipagos.exam.services.CounterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/** 
* class to define count controller
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
@RequestMapping("v1/counter")
@RestController
@Tag(name = "Count Controller", description = "controller to count sentences")
public class CounterController {

	/**
	 * CounterService counterService
	 */
	@Autowired
	private CounterService counterService;

	/**
	 * @param sentence
	 * @return ResponseEntity<ResponseItem<Integer>>
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "count words", description = "count the quantity of words in a sentence")
	@ApiResponse(responseCode = "200", description = "success, the response is encapsulated in a response item",
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
					schema = @Schema(implementation = Integer.class), examples = @ExampleObject(name = "valid response",
							summary = "valid response of a counter", value = """
									{
									      "code": 0,
										  "message": "success",
										  "payload": 5
									}
									""")))
	public ResponseEntity<ResponseItem<Integer>> countWords(
			@Parameter(description = "sentence to count words", example = "hola ana banana", required = true)
			@RequestParam String sentence) {

		int code = 0;
		String message = "error";
		Integer value = 0;
		try {
			value = counterService.CountWords(sentence);
			message = "success";
		} catch (ProntipagosException e) {
			code = -1;
			message = e.getMessage();
		} catch (Exception e) {
			code = -100;
			message = e.getMessage();
		}
		ResponseItem<Integer> response = new ResponseItem<>(message, code, value);
		return ResponseEntity.ok(response);
	}
}
