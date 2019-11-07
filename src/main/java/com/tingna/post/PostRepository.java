package com.tingna.post;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
=======

>>>>>>> ae25b79fed11168d904f5d8e5ecaa76c70e81e8e
public interface PostRepository extends JpaRepository<Post, Long> {
  Post findByIdAndStatus(Long id, PostStatus status);
}
