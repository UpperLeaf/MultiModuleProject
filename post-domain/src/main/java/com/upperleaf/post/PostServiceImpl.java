package com.upperleaf.post;

import com.upperleaf.post.dto.PostServiceRequestDto;
import com.upperleaf.post.dto.PostServiceResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public Long createPost(PostServiceRequestDto requestDto) {
        Post post = Post.of(requestDto);
        postRepository.save(post);
        return post.getId();
    }

    @Override
    public Long deletePost(Long id) {
        postRepository.deleteById(id);
        return id;
    }

    @Override
    public PostServiceResponseDto retrievePostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(id + " is not existed"));
        return post.createResponseDto();
    }

    @Override
    public List<PostServiceResponseDto> retrievePostAll() {
        return postRepository.findAll().stream().map(Post::createResponseDto).collect(Collectors.toList());
    }
}
