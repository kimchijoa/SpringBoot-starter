package com.kkh.spingboot.web;

import com.kkh.spingboot.service.posts.PostsService;
import com.kkh.spingboot.web.dto.PostsResponseDto;
import com.kkh.spingboot.web.dto.PostsUpdateRequestDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class IndexController {
    
    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
//    @GetMapping("/posts/update/{id}")
//    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
//        return postsService.update(id, requestDto);
//    }
    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

}
