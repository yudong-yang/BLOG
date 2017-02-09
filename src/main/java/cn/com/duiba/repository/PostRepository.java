package cn.com.duiba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.com.duiba.entity.Post;

public interface PostRepository extends PagingAndSortingRepository<Post, Integer>, JpaRepository<Post, Integer> {
	
	

}
