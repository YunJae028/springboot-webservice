package com.facvis.dongyang.springboot.domain.posts;

import com.facvis.dongyang.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // Getter 메소드 추가
@NoArgsConstructor //룸복 기본생성자 자동 추가
@Entity //실제 DB의 테이블과 링크될 클래스임을 의미
// -> JPA사용시 실제쿼리 대신 entity 클래스 수정통해 작업
public class Posts extends BaseTimeEntity {
    @Id //테이블 pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) //기본값 외 추가
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //빌드패턴 클래스 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
