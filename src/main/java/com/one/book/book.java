package com.one.book;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class book {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int price;
	private Date publisheddate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="abid")
	private Author author;
	
	



	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", price=" + price + ", publisheddate=" + publisheddate
				+ ", author=" + author ;
	}


	


	
	
}
