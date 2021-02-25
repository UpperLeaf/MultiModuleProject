package com.upperleaf.post;

import com.upperleaf.post.dto.PostServiceRequestDto;
import com.upperleaf.post.dto.PostServiceResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor
@Entity @Builder @Getter
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;


    public static Post of(PostServiceRequestDto requestDto){
        return Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .build();
    }


    public PostServiceResponseDto createResponseDto() {
        return PostServiceResponseDto.builder()
                .id(id)
                .title(title)
                .content(content)
                .createdAt(createdAt)
                .build();
    }
}
