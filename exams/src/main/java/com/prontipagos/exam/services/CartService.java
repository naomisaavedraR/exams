package com.prontipagos.exam.services;

import java.util.Map;

import com.prontipagos.exam.exception.ProntipagosException;

public interface CartService {

	public boolean addToCart(String product, Long price) throws ProntipagosException;

	public Map<String, Long> getCart() throws ProntipagosException;

}
