package com.one.book;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<book, Integer> {

	public abstract List<book> findByName(String name); 
	
	public abstract List<book> findByNameAndPrice(String name, Integer price);
	
	public abstract List<book> findByNameLike(String name);
	
	public abstract List<book> findByNameStartingWith(String name);
	
	public abstract List<book> findByPublisheddateBefore(Date date);
	
	public abstract List<book> findByPublisheddateBetween(Date start, Date end);
	
//	**********************with query********************************
	
	@Query("from book b where b.name=?1")
	public abstract List<book> getbyName2(String name);
	
	@Query("from book b where b.name=?1 and b.price=?2")
	public abstract List<book> getbyNameAndPrice2(String name, Integer price);
	
	@Query("from book b where b.name like?1")
	public abstract List<book> getbyNameLike2(String name);
	
	@Query("from book b where b.price between ?1 and ?2")
	public abstract List<book> getPriceBetween2(Integer price, Integer price1);
	
	@Query("from book b order by name")
	public abstract List<book> getorderbyName();
	
	//*************************onetoone*************************
	
	@Query("select b.author from book b where b.id=?1")
	public abstract Author getauthorbyid(Integer id);
	
	@Query("select b from book b join b.author r where r.aid=?1")
	public abstract List<book> getbookbyid(Integer id);
}
