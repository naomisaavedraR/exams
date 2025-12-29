/** Classname: CartRequest 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/** 
* class to define the TO of the cart
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
@Schema(name = "CartRequest", description = "Request to upload a product to the cart")
public class CartRequest implements Serializable{

	/** Class serial version UID */
	private static final long serialVersionUID = 1L;

	/**
	 * String name
	 */
	@Schema(description = "name of the product", example = "apple")
	@NotNull
	private String name;

	/**
	 * Long price
	 */
	@Schema(description = "price of the product", example = "500.00")
	@NotNull
	private Long price;

	/**
	 * Default constructor
	 */
	public CartRequest() {
		super();
	}

	/**
	 * @param name
	 * @param price
	 */
	public CartRequest(String name, Long price) {
		super();
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}


	

}
