package com.one.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController3 {

	@Autowired
	private BookRepo br;
	
	@GetMapping("getauthorbyid/{id}")
	public Author getauthorbyid(@PathVariable Integer id) {
		Author a =br.getauthorbyid(id);
		System.out.println(a);
		return  a;
	}
		@GetMapping("getbookbyid/{id}")
		public List<book> getbookbyid(@PathVariable Integer id)
		{
			List<book> bk = br.getbookbyid(id);
			System.out.println(bk);
			return bk;
		}
	
}
