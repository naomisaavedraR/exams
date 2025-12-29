/** Classname: CartController 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.prontipagos.exam.dto.CartRequest;
import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.response.ResponseItem;
import com.prontipagos.exam.services.CartService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/** 
* class to define cart controller
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
@RequestMapping("v1/cart")
@RestController
@Tag(name = "Cart Controller", description = "controller to update a cart")
public class CartController {

	/**
	 * CartService cartService
	 */
	@Autowired
	private CartService cartService;

	/**
	 * @param cartRequest
	 * @return ResponseEntity<ResponseItem<Boolean>>
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "update an item", description = "add a product with name and price to the cart")
	@ApiResponse(responseCode = "200", description = "success, the response is encapsulated in a response item",
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
					schema = @Schema(implementation = Boolean.class), examples = @ExampleObject(name = "valid response",
							summary = "valid response of a upload", value = """
									{
									      "code": 0,
										  "message": "success",
										  "payload": true
									}
									""")))
	public ResponseEntity<ResponseItem<Boolean>> submitProduct(@RequestBody CartRequest cartRequest) {

		int code = 0;
		String message = "error";
		Boolean value = false;
		try {
			value = cartService.addToCart(cartRequest.getName(), cartRequest.getPrice());
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

	/**
	 * @return ResponseEntity<ResponseItem<Map<String, Long>>>
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "get the cart", description = "get a map with all the items in a cart")
	@ApiResponse(responseCode = "200", description = "success, the response is encapsulated in a response item",
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
					schema = @Schema(implementation = Map.class),
					examples = @ExampleObject(name = "valid response", summary = "valid response of a cart", value = """
							{
							      "code": 0,
								  "message": "success",
								  "payload":{
											  "ensalada": 100,
											  "taco": 100
											}
							}
							""")))
	public ResponseEntity<ResponseItem<Map<String, Long>>> getCart() {

		int code = 0;
		String message = "error";
		Map<String, Long> value = null;
		try {
			value = cartService.getCart();
			message = "success";

		} catch (ProntipagosException e) {
			code = -1;
			message = e.getMessage();
		} catch (Exception e) {
			code = -100;
			message = e.getMessage();
		}
		ResponseItem<Map<String, Long>> response = new ResponseItem<>(message, code, value);
		return ResponseEntity.ok(response);
	}

}
