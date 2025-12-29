package com.prontipagos.exam.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prontipagos.exam.dto.CartRequest;
import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.response.ResponseItem;
import com.prontipagos.exam.services.CartService;

@RequestMapping("v1/cart")
@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping
	public ResponseEntity<ResponseItem<Boolean>> submitProduct(@RequestBody CartRequest cartRequest) {

		int code = 0;
		String message = "error";
		Boolean value = false;
		try {
			value = cartService.addToCart(cartRequest.getName(), cartRequest.getPrice());
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

	@GetMapping
	public ResponseEntity<ResponseItem<Map<String, Long>>> getCart() {

		int code = 0;
		String message = "error";
		Map<String, Long> value = null;
		try {
			value = cartService.getCart();
			message ="success";

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
