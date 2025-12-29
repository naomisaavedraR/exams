package com.prontipagos.exam.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CartSingleton {

	private static CartSingleton instance;

	private final Map<String, Long> items = new ConcurrentHashMap<>();

	private CartSingleton() {

	}

	public static synchronized CartSingleton getInstance() {
		if (instance == null) {
			instance = new CartSingleton();
		}
		return instance;
	}

	public void addItem(String id, Long item) {
		items.put(id, item);
	}

	public Map<String, Long> getItems() {
		return items;
	}
}
