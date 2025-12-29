package com.prontipagos.exam.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.response.ResponseItem;
import com.prontipagos.exam.services.ThreadSafeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("v1/thread")
@RestController
public class ThreadController {

	@Autowired
	private ThreadSafeService threadSafeService;

	@GetMapping
	public ResponseEntity<ResponseItem<Long>> validateThread(@RequestParam Long cycles) {
		
		int code = 0;
		String message = "error";
		Long value = 0L;
		try {
			value = threadSafeService.validateSafeThreads(cycles);
			message ="success";

		}catch(ProntipagosException e) {
			code = -1;
			message = e.getMessage();
		}catch(Exception e) {
			code = -100;
			message = e.getMessage();
		}
		ResponseItem<Long> response = new ResponseItem<>(message,code,value);
		return ResponseEntity.ok(response);
	}

}
