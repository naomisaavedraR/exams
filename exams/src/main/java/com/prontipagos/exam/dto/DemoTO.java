package com.prontipagos.exam.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(name = "DemoTO", description = "Request to validate if the animal is a platypus")
public class DemoTO {

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

	public DemoTO() {
		super();
	}

	public DemoTO(String name, Long age, boolean aPlatypus, String sound) {
		super();
		this.name = name;
		this.age = age;
		this.platypus = aPlatypus;
		this.sound = sound;
	}

	public DemoTO(DemoTO other) {
		this.name = other.name;
		this.age = other.age;
		this.platypus = other.platypus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Boolean getPlatypus() {
		return platypus;
	}

	public void setPlatypus(Boolean platypus) {
		this.platypus = platypus;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public DemoTO findSound() {
		DemoTO copy = new DemoTO(this);
		if (copy.getPlatypus()) {
			copy.sound = "brrrr";

		} else {
			copy.sound = "miau";
		}
		return copy;
	}

	@Override
	public String toString() {
		return "DemoTO [name=" + name + ", age=" + age + ", aPlatypus=" + platypus + ", sound=" + sound + "]";
	}

}
