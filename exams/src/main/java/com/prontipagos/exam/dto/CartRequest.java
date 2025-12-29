package com.prontipagos.exam.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(name = "CartRequest", description = "Request to upload a product to the cart")
public class CartRequest {

	@Schema(description = "name of the product", example = "apple")
	@NotNull
	private String name;

	@Schema(description = "price of the product", example = "500.00")
	@NotNull
	private Long price;

	public CartRequest() {
		super();
	}

	public CartRequest(String name, Long price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}
