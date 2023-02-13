package com.one.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Author {

	@Id
	@GeneratedValue
	private int aid;
	private String aname;
	private int aphone;
	
	
	@Override
	public String toString() {
		return "Author [aid=" + aid + ", aname=" + aname + ", aphone=" + aphone + "]";
	}
	
}
