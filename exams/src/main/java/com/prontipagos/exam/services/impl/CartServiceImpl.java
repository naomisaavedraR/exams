/** Classname: CartServiceImpl 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.services.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.prontipagos.exam.exception.ProntipagosException;
import com.prontipagos.exam.repository.CartSingleton;
import com.prontipagos.exam.services.CartService;

/** 
* class to define cart service
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
@Service
public class CartServiceImpl implements CartService {

	@Override
	public boolean addToCart(String product, Long price) throws ProntipagosException {

		if (product == null || product.trim().isEmpty()) {
			throw new ProntipagosException("producto vacio");
		}
		if (price == null || price < 0L) {
			throw new ProntipagosException("Precio invalido");

		}
		CartSingleton.getInstance().addItem(product, price);
		return true;
	}

	@Override
	public Map<String, Long> getCart() throws ProntipagosException {

		Map<String, Long> result = CartSingleton.getInstance().getItems();

		if (result == null) {
			throw new ProntipagosException("carrito invalido");
		}

		return result;
	}

}
