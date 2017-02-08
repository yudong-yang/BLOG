package cn.com.duiba.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import cn.com.duiba.entity.Post;



@Service
public class PostService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	  public Post getByid(final int id) {
	        String sqlStr = " SELECT title,content,created,updated FROM post WHERE id =? ";
	        final Post post = new Post();
	        jdbcTemplate.query(sqlStr, new Object[]{id},
	                new RowCallbackHandler() {
	                    public void processRow(ResultSet rs) throws SQLException {
	                    	post.setContent(rs.getString("content"));
	                    	post.setTitle(rs.getString("title"));
	                    	post.setCreated(rs.getDate("created"));
	                    	
	                    	post.setId(id);
	                    }
	                });
	        return post;
	    }
}
