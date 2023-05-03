package com.github.seseque.dockerposts.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public PostRes createPost(PostReq postReq) {
        Post saved = postRepository.save(postMapper.toEntity(postReq));
        return postMapper.toResponse(saved);
    }

    @Override
    public PostRes getPost(Long id) {
        Post saved = postRepository.getReferenceById(id);
        return postMapper.toResponse(saved);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public PostRes updatePost(Long id, PostReq postReq) {
        Post saved = postRepository.getReferenceById(id);
        saved.setText(postReq.getText());
        return postMapper.toResponse(postRepository.save(saved));
    }
}
