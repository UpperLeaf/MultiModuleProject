package com.upperleaf.post;

import com.upperleaf.post.dto.PostServiceRequestDto;
import com.upperleaf.post.dto.PostServiceResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    @Transactional
    @Test
    public void createPostAndGet() {
        PostServiceRequestDto requestDto =
                PostServiceRequestDto.builder().title("제목").content("내용").build();

        Long id = postService.createPost(requestDto);

        PostServiceResponseDto responseDto = postService.retrievePostById(id);
        assertThat(responseDto.getTitle()).isEqualTo(requestDto.getTitle());
        assertThat(responseDto.getContent()).isEqualTo(requestDto.getContent());
        assertThat(responseDto.getId()).isEqualTo(id);
        //assertThat(responseDto.getCreatedAt()).isNotNull();
    }

}