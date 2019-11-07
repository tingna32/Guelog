package com.tingna.index;

import lombok.RequiredArgsConstructor;
import com.tingna.post.PostRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

<<<<<<< HEAD
=======


>>>>>>> ae25b79fed11168d904f5d8e5ecaa76c70e81e8e
@Controller
@RequiredArgsConstructor
public class IndexController {

  private final PostRepository postRepository;

  @GetMapping("/")
  public String home(Model model, Pageable pageable){
    model.addAttribute("posts", postRepository.findAll(pageable));
    return "index";
  }
}
