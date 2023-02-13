package com.one.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController2 {

	@Autowired
	private BookRepo br2;
	
	@GetMapping("getbyname2/{name}")
	public List<book> getbyname2(@PathVariable (name="name") String name)
	{
		List<book> bk2 = br2.getbyName2(name);
		System.out.println(bk2);
		return bk2;
	}
	
	@GetMapping("getbynameandprice2/{name}/{price}")
	public List<book> getbynameandprice2(@PathVariable String name, @PathVariable Integer price)
	{
		List<book> bk2 = br2.getbyNameAndPrice2(name, price);
		System.out.println(bk2);
		return bk2;
	}
	
	@GetMapping("getbynamelike2/{name}")
	public List<book> getbynamelike2(@PathVariable String name){
		List<book> bk2 = br2.getbyNameLike2("%"+name+"%");
		System.out.println(bk2);
		return bk2;
	}
	@GetMapping("getpricebetween2/{start}/{end}")
	public List<book> getpricebetween2(@PathVariable Integer start, @PathVariable Integer end){
		List<book> bk2 = br2.getPriceBetween2(start,end);
		System.out.println(bk2);
		return bk2;
	}
	
	@GetMapping("orderbyname")
	public List<book> orderbyname(){
		List<book> bk2 = br2.getorderbyName();
		System.out.println(bk2);
		return bk2;
	}
	
	
}
