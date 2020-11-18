package com.facvis.dongyang.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // Getter 메소드 추가
@NoArgsConstructor //룸복 기본생성자 자동 추가
@Entity //테이블과 링크될 클래스
public class Posts {
    @Id //테이블 pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) //기본값 외 추가
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
