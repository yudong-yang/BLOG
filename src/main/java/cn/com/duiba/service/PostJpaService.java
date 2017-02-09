package cn.com.duiba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.com.duiba.entity.Post;
import cn.com.duiba.repository.PostRepository;



@Service
public class PostJpaService {

	@Autowired
	private PostRepository postRepository;
	
	public Post getByid(final int id) {
		return postRepository.findOne(id);
	}
	
	public List<Post> findAllPosts() {
		return postRepository.findAll();
	}
	
	public void save(Post post) {
		postRepository.save(post);
	}

	public List<Post> findAllPost() {
		return postRepository.findAll();
	}
	
	public Page<Post> GetPostPage(Pageable pageable) {
		return postRepository.findAll(pageable);
	}
}
