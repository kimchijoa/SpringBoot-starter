package com.kkh.spingboot.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // get 메소드 생성
@RequiredArgsConstructor //생성자 생성(final만)
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
