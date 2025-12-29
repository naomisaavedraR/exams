/** Classname: CartSingleton 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 
* class to  define a singleton for persistence
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
public class CartSingleton {

	/**
	 * CartSingleton instance
	 */
	private static CartSingleton instance;

	/**
	 * Map<String,Long> items
	 */
	private final Map<String, Long> items = new ConcurrentHashMap<>();

	/**
	 * Default constructor
	 */
	private CartSingleton() {

	}

	/**
	 * @return CartSingleton
	 */
	public static synchronized CartSingleton getInstance() {
		if (instance == null) {
			instance = new CartSingleton();
		}
		return instance;
	}

	/**
	 * @param id
	 * @param item
	 */
	public void addItem(String id, Long item) {
		items.put(id, item);
	}

	/**
	 * @return  Map<String, Long> 
	 */
	public Map<String, Long> getItems() {
		return items;
	}
}
