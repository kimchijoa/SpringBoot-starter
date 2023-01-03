package com.kkh.spingboot.service.posts;

import com.kkh.spingboot.domain.posts.PostsRepository;
import com.kkh.spingboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;  //이거 왜 final 붙음? @RequiredArgsConstructor를 통해 Bean 객체 주입을 확실화 하기 위해서!

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
