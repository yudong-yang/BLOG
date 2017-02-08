package cn.com.duiba.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.com.duiba.entity.Comment;

@Service
public class CommentService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void UpdateComment(Comment comment){
		jdbcTemplate.update(
                "insert into comment(content, post, created) values(?, ?, ?);",
                comment.getContent(), comment.getPost(), new Date());
		
	}
}
