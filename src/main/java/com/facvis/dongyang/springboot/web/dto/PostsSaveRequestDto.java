package com.facvis.dongyang.springboot.web.dto;

import com.facvis.dongyang.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title,String content,String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}

//Entity클래스와 유사하지만 따로 Dto 클래스를 추가생성한 이유
//Entity클래스 절대 Request/Response 클래스로 사용 x => Entity클래스는 데이터베이스 핵심 클래스(쓸데없는 변경 X)
// Response,Request용 Dto는 View를 위한 클래스이므로 자주 변경 필요