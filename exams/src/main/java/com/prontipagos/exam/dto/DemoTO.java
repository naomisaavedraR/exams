/** Classname: DemoTO 
* Author: Naomi Saavedra
* Date: 2025/12/29 
* © Concepto Móvil S.A. de C.V. 
*/
package com.prontipagos.exam.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/** 
* class to define a Demo TO
* @author: Naomi Saavedra
* @version: 1.0 * 
*/
@Schema(name = "DemoTO", description = "Request to validate if the animal is a platypus")
public class DemoTO implements Serializable{

	/** Class serial version UID */
	private static final long serialVersionUID = 1L;

	@Schema(description = "name of the animal", example = "perry")
	@NotNull
	private String name;

	@Schema(description = "age of the animal", example = "perry")
	@NotNull
	@Positive
	private Long age;

	@Schema(description = "validate if is a platypus", example = "perry")
	@NotNull
	private Boolean platypus;

	@Schema(description = "Sound of the animal", example = "brrrr")
	private String sound;

	/**
	 * Default constructor
	 */
	public DemoTO() {
		super();
	}

	/**
	 * @param name
	 * @param age
	 * @param aPlatypus
	 * @param sound
	 */
	public DemoTO(String name, Long age, boolean aPlatypus, String sound) {
		super();
		this.name = name;
		this.age = age;
		this.platypus = aPlatypus;
		this.sound = sound;
	}

	/**
	 * @param other
	 */
	public DemoTO(DemoTO other) {
		this.name = other.name;
		this.age = other.age;
		this.platypus = other.platypus;
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
	 * @return the age
	 */
	public Long getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Long age) {
		this.age = age;
	}

	/**
	 * @return the platypus
	 */
	public Boolean getPlatypus() {
		return platypus;
	}

	/**
	 * @param platypus the platypus to set
	 */
	public void setPlatypus(Boolean platypus) {
		this.platypus = platypus;
	}

	/**
	 * @return the sound
	 */
	public String getSound() {
		return sound;
	}

	/**
	 * @param sound the sound to set
	 */
	public void setSound(String sound) {
		this.sound = sound;
	}

	/**
	 * @return DemoTO
	 */
	public DemoTO findSound() {
		DemoTO copy = new DemoTO(this);
		if (copy.getPlatypus()) {
			copy.sound = "brrrr";

		} else {
			copy.sound = "miau";
		}
		return copy;
	}

	/**
	 * @return String
	 */
	@Override
	public String toString() {
		return "DemoTO [name=" + name + ", age=" + age + ", platypus=" + platypus + ", sound=" + sound + "]";
	}


	

}
