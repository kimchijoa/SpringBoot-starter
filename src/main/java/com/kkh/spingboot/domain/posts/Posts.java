package com.kkh.spingboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본 생성자 생성
@Entity //테이블과 링크될 클래스임을 명시
public class Posts {
    @javax.persistence.Id
    @Id //PK 필드 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙 나타냄
    private Long id;

    @Column(length = 500, nullable = false) // 기본적으로 Column은 명시 안해도 되나, 변경 필요한 옵션이 있따면 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
