package com.tingna.post;

import lombok.RequiredArgsConstructor;
import com.tingna.category.Category;
import com.tingna.category.CategoryService;
import com.tingna.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

<<<<<<< HEAD
=======

>>>>>>> ae25b79fed11168d904f5d8e5ecaa76c70e81e8e
@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

  private final PostService postService;
  private final CategoryService categoryService;

  @ModelAttribute("categories")
  public List<Category> categories(){
    return categoryService.findAll();
  }

  @GetMapping("/{id}")
  public String findByPost(@PathVariable Long id, Model model) {
    Post post = postService.findByIdAndStatus(id, PostStatus.Y);
    if (post == null) {
      throw new NotFoundException(id + " not found");
    }
    model.addAttribute("post", post);
    return "post/post";
  }

  @GetMapping("/new")
  public String newPost(PostDto postDto) {
    return "post/new";
  }

  @GetMapping("/edit/{id}")
  public String editPost(@PathVariable Long id, Model model) {
    Post post = postService.findByIdAndStatus(id, PostStatus.Y);
    if (post == null) {
      throw new NotFoundException(id + " not found");
    }
    PostDto createPost = new PostDto();
    createPost.setCategoryId(post.getCategory().getId());
    createPost.setCategoryName(post.getCategory().getName());
    createPost.setTitle(post.getTitle());
    createPost.setCode(post.getCode());
    createPost.setContent(post.getContent());
    createPost.setId(id);
    model.addAttribute("editPost", createPost);
    return "post/edit";
  }

  @PostMapping
  public String createPost(@ModelAttribute @Valid PostDto createPost, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      return "post/new";
    }
    Post post = new Post(createPost.getTitle(),
      createPost.getContent(),
      createPost.getCode(),
      PostStatus.Y,
      new Category(createPost.getCategoryId()));
    Post newPost = postService.createPost(post);
    model.addAttribute("post", newPost);
    return "redirect:/posts/" + newPost.getId();
  }

  @PostMapping("/{id}/edit")
  public String modifyPost(@PathVariable Long id, @ModelAttribute("editPost") @Valid PostDto createPost, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "post/edit";
    }
    postService.updatePost(id, new Post(
      createPost.getTitle(),
      createPost.getContent(),
      createPost.getCode(),
      PostStatus.Y,
      new Category(createPost.getCategoryId())
    ));
    return "redirect:/posts/" + id;
  }

  @PostMapping("{id}/delete")
  public String deletePost(@PathVariable Long id) {
    postService.deletePost(id);
    return "redirect:/#/";
  }
}
