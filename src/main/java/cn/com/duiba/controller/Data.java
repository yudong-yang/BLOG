package cn.com.duiba.controller;



import java.util.ArrayList;
import java.util.List;

import cn.com.duiba.entity.Post;

public class Data {

    public static byte[] avatar = null;

    public static List<Post> posts = new ArrayList<>();
    static {
        posts.add(new Post("title1", "content1"));
        posts.add(new Post("title2", "content2"));
    }

    public static Post getById(int id) {
    	Post p = posts.get(id);
    	return p;
    }

    public static void add(String title, String content) {
        posts.add(new Post(title, content));
    }

    public static Post add(Post post) {
        Post result = new Post(post.getTitle(), post.getContent());
        posts.add(result);
        return result;
    }

}