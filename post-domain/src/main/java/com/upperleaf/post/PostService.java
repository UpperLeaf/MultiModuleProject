package com.upperleaf.post;

import com.upperleaf.post.dto.PostServiceRequestDto;
import com.upperleaf.post.dto.PostServiceResponseDto;

import java.util.List;

public interface PostService {

    Long createPost(PostServiceRequestDto requestDto);

    Long deletePost(Long id);

    PostServiceResponseDto retrievePostById(Long id);

    List<PostServiceResponseDto> retrievePostAll();
}
