/** Classname: CartService 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.services;

import java.util.Map;

import com.prontipagos.exam.exception.ProntipagosException;

/** 
* interface to define cart service
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
public interface CartService {

	/**
	 * @param product
	 * @param price
	 * @return boolean
	 * @throws ProntipagosException
	 */
	public boolean addToCart(String product, Long price) throws ProntipagosException;

	/**
	 * @return Map<String, Long>
	 * @throws ProntipagosException
	 */
	public Map<String, Long> getCart() throws ProntipagosException;

}
