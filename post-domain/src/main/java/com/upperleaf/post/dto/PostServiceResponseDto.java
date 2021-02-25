package com.upperleaf.post.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data @Builder
public class PostServiceResponseDto {
    private Long id;
    private String title;
    private String content;
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;


}
