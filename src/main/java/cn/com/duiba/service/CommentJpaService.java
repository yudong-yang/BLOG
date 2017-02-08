package cn.com.duiba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.duiba.entity.Comment;
import cn.com.duiba.repository.CommentRepository;
@Service
public class CommentJpaService {
	@Autowired
	private CommentRepository commentRepository;
	
	public void SaveComment(Comment comment){
		commentRepository.save(comment);
	}
	
	public List<Comment> findbyPostId(int id){
		return commentRepository.findByPost_id(id);
	}
}
