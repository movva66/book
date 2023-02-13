package com.one.book;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;

@RestController
public class BookController {

	private final static Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookRepo br;
	
	@PostMapping("savebook")
	@Operation( description = "This is Save method",
	requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "Requires id, name, price, author"))
	public ResponseEntity<book> savebook(@RequestBody book bk)
	{
		System.out.println(bk);
		bk.setPublisheddate(new Date());
		book b= br.save(bk);
		ResponseEntity<book> re=new ResponseEntity<>(b,HttpStatus.OK);
		return re;
	}
	
	@PostMapping("saveall")
	public List<book> saveall(@RequestBody List<book> books)
	{
		System.out.println(books);
		br.saveAll(books);
		return books;
	}
	
	@GetMapping("getbyid/{id}")
	
	public book getbyid(@PathVariable (name="id") Integer id)
	{
//		System.out.println("id::"+id);
		Optional<book> opt = br.findById(id);
		LOGGER.info("getbyid");
		LOGGER.debug("getbyid");
		LOGGER.trace("getbyid");
		LOGGER.warn("getbyid");
		LOGGER.error("getbyid");
		if(opt.isPresent()) {
			System.out.println("book::"+opt.get());
			return opt.get();
		   }
		else {
			System.out.println("not found");
			return null;
		}
	}
	
	@GetMapping("getall")
	public List<book> getall(@RequestBody List<book> book){
		List<book> bk = br.findAll(); 
		//System.out.println(bk);
		return bk;
	}
	@DeleteMapping("deletebyid")
	public book deletebyid (@RequestBody book bk) {
		System.out.println(bk);
		br.delete(bk);
		return bk;
	}
	@GetMapping("getbyname/{name}")
	public List<book> getbyname(@PathVariable(name="name") String name)
	{
		List<book> bk = br.findByName(name);
		System.out.println(bk);
		return bk;
	}
	
	@GetMapping("getbynameandprice/{name}/{price}")
	public List<book> getbynameandprice(@PathVariable(name="name") String name,
	                                    @PathVariable(name="price") Integer price)
	{
		List<book> bk = br.findByNameAndPrice(name, price);
		System.out.println(bk);
		return bk;
	}
	
	@GetMapping("getbynamelike/{partialname}")
	public List<book> getbynamelike(@PathVariable(name = "partialname") String partialname)
	{
		List<book> bk = br.findByNameLike("%"+partialname+"%");
		System.out.println(bk);
		return bk;
	}
	
	@GetMapping("getbynamestartswith/{partialname}")
	public List<book> getbynamestartswith(@PathVariable(name="partialname") String partialname){
		List<book> bk = br.findByNameStartingWith(partialname);
		System.out.println(bk);
		return bk;
	}
	
	@GetMapping("getbeforedate/{date}")
	public List<book> getdatebefore(@PathVariable(name = "date") String Date)
	throws Exception
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = df.parse(Date);
		List<book> bk = br.findByPublisheddateBefore(d);
		System.out.println(bk);
		return bk;
	}
	@GetMapping("getdatabetween/{start}/{end}")
	public List<book> getdatebetween(@PathVariable(name="start") String start, @PathVariable(name="end") String end)
	throws Exception
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(start);
		Date date1 = df.parse(end);
		List<book> bk = br.findByPublisheddateBetween(date, date1);
		return bk;
	}
	
}
