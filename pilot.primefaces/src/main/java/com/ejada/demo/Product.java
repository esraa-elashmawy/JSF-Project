package com.ejada.demo;

import java.io.Serializable;

public class Product implements Serializable  {
	public Product(Long id, String code, String desc) {
		this.code = code;
		this.id = id;
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private Long id;
	private String code;
	private String desc;
}
