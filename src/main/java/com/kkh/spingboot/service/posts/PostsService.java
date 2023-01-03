package com.kkh.spingboot.service.posts;

import com.kkh.spingboot.domain.posts.Posts;
import com.kkh.spingboot.domain.posts.PostsRepository;
import com.kkh.spingboot.web.dto.PostsListResponseDto;
import com.kkh.spingboot.web.dto.PostsResponseDto;
import com.kkh.spingboot.web.dto.PostsSaveRequestDto;
import com.kkh.spingboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;  //이거 왜 final 붙음? @RequiredArgsConstructor를 통해 Bean 객체 주입을 확실화 하기 위해서!

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id:" + id ));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id:" + id ));
        postsRepository.delete(posts);
    }
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다. id:" + id ));
        return new PostsResponseDto(entity);
    }
}
