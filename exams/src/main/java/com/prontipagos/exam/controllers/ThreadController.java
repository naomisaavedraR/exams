/** Classname: ThreadController 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.response.ResponseItem;
import com.prontipagos.exam.services.ThreadSafeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** 
* class to define thread controller
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
@RequestMapping("v1/thread")
@RestController
@Tag(name = "Thread Controller", description = "controller to manage threads")
public class ThreadController {

	/**
	 * ThreadSafeService threadSafeService
	 */
	@Autowired
	private ThreadSafeService threadSafeService;

	/**
	 * @param cycles
	 * @return ResponseEntity<ResponseItem<Long>>
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "ejecute two threads with opposite operations",
			description = "sum and substract n cycles of a number to the same variable.")
	@ApiResponse(responseCode = "200",
			description = "success, the response is encapsulated in a response item",
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
					schema = @Schema(implementation = Long.class), examples = @ExampleObject(name = "valid response",
							summary = "unique valid response", value = """
									{
									      "code": 0,
										  "message": "success",
										  "payload": 0
									}
									""")

			)

	)
	public ResponseEntity<ResponseItem<Long>> validateThread(
			@Parameter(description = "number of cycles to do", example = "1000000", required = true)
			@RequestParam Long cycles) {

		int code = 0;
		String message = "error";
		Long value = 0L;
		try {
			value = threadSafeService.validateSafeThreads(cycles);
			message = "success";

		} catch (ProntipagosException e) {
			code = -1;
			message = e.getMessage();
		} catch (Exception e) {
			code = -100;
			message = e.getMessage();
		}
		ResponseItem<Long> response = new ResponseItem<>(message, code, value);
		return ResponseEntity.ok(response);
	}

}
