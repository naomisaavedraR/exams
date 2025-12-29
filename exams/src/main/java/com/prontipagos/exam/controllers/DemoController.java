/** Classname: DemoController 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prontipagos.exam.dto.DemoTO;
import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.response.ResponseItem;
import com.prontipagos.exam.services.DemoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/** 
* class to define demo controller
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
@RestController
@RequestMapping("v1/demo")
@Tag(name = "Demo Controller", description = "controller to show the usage of swagger")
public class DemoController {

	/* Logger Object */
	private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);

	/**
	 * DemoService demoService
	 */
	@Autowired
	private DemoService demoService;

	/**
	 * @param request
	 * @return ResponseEntity<ResponseItem<DemoTO>>
	 */
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "get the sound of a platypus",
			description = "validate if the animal is a platypus and return the sound")
	@ApiResponse(
			responseCode = "200",
			description = "success, the response is encapsulated in a response item",
			content = @Content(
					mediaType = MediaType.APPLICATION_JSON_VALUE,
					schema = @Schema(implementation = DemoTO.class),
					examples = 
							@ExampleObject(
									name="valid response",
									summary ="valid response of a platypus",
									value = """
											{
											    "code": 0,
											    "message": "success",
											    "payload": {
											        "age": 3,
											        "name": "Perry",
											        "platypus": false,
											        "sound": "miau"
											    }
											}
											"""
									)
					
					)
					
			)
	public ResponseEntity<ResponseItem<DemoTO>> isAPlatypus(@io.swagger.v3.oas.annotations.parameters.RequestBody(
			required = true, description = "data to request the validation of the animal",
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
					schema = @Schema(implementation = DemoTO.class),
					examples = {
							@ExampleObject(name = "valid request no platypus",
									summary = "valid animal request ", value = """
												{
												    "name":"Perry",
												    "age":3,
												    "platypus":false
												}
											"""),
							@ExampleObject(name = "valid request  platypus",
									summary = "valid animal request ", value = """
												{
												    "name":"Perry",
												    "age":3,
												    "platypus":true
												}
											""") }

			)) @RequestBody DemoTO request) {

		int code = 0;
		String message = "error";
		DemoTO value = null;
		try {
			LOG.info("request: {}", request);
			value = demoService.knowIfitsAPlatypus(request);
			message = "success";
		} catch (ProntipagosException e) {
			code = -1;
			message = e.getMessage();
		} catch (Exception e) {
			code = -100;
			message = e.getMessage();
		}
		ResponseItem<DemoTO> response = new ResponseItem<>(message, code, value);
		return ResponseEntity.ok(response);

	}

}
