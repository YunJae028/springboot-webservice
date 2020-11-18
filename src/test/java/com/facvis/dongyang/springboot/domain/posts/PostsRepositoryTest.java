package com.facvis.dongyang.springboot.domain.posts;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class) //스프링 실행자 사용 , 스프링 부트 테스트와 JUnit사이에 연결자 역할
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After //단위테스트가 끝날때마다 수행되는 메소드를 지정
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void postSave_load(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() //insert/update쿼리 실행 id값 있으면 update 아니면 insert 쿼리 실행
                    .title(title)
                    .content(content)
                    .author("tjdbswo7@gmail.com")
                    .build());

        //when
        //테이블 posts에 있는 모든 데이터를 조회해오는 메소드
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
