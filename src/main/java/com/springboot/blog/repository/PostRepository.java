package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p from Post p " +
            "WHERE p.title LIKE CONCAT('%',:searchText,'%')" +
            "OR p.description LIKE CONCAT('%',:searchText,'%')")
    List<Post> searchPosts(String searchText);

    @Query(value = "SELECT * from posts p" +
            "WHERE p.title LIKE CONCAT('%',:searchText, '%')" +
            "OR p.description LIKE CONCAT('%',:searchText, '%')", nativeQuery = true)
    List<Post> searchPostsSQL(String searchText);
}
