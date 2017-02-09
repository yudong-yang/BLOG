package cn.com.duiba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.com.duiba.entity.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer>,JpaRepository<Person, Integer> ,CrudRepository<Person, Integer>{
	
	@Query(" select distinct(name) from Person ")
	public List<String> findname();
	
}
