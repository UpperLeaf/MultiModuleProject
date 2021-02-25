package com.upperleaf.post.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class PostServiceRequestDto {
    String title;
    String content;
}
