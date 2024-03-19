package com.wipro.sec04.helper;

import com.wipro.common.Util;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
	private int id;
	private String name;
	private int age;

	public User(int id) {
		this.id = id;
		this.name = Util.faker()
				.name()
				.fullName();
		this.age = Util.faker()
				.random()
				.nextInt(1, 30);
	}

}
