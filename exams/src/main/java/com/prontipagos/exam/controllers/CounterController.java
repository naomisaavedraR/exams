package com.prontipagos.exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.response.ResponseItem;
import com.prontipagos.exam.services.CounterService;

@RequestMapping("v1/counter")
@RestController
public class CounterController {

	@Autowired
	private CounterService counterService;

	@GetMapping
	public ResponseEntity<ResponseItem<Integer>> countWords(@RequestParam String sentence) {

		int code = 0;
		String message = "error";
		Integer value = 0;
		try {
			value = counterService.CountWords(sentence);
			message ="success";
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
