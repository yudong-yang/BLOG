package cn.com.duiba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.com.duiba.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByPost_id(Integer id);

}
