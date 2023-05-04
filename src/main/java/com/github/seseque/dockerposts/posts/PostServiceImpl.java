package com.github.seseque.dockerposts.posts;

import com.github.seseque.dockerposts.config.UserServiceProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final RestTemplate restTemplate;
    private final UserServiceProperties userServiceProperties;

    @Override
    public PostRes createPost(PostReq postReq) {
        Post saved = postRepository.save(postMapper.toEntity(postReq));
        updateAmountOfPosts(postReq.authorId, 1);
        return postMapper.toResponse(saved);
    }

    @Override
    public PostRes getPost(Long id) {
        Post saved = postRepository.getReferenceById(id);
        return postMapper.toResponse(saved);
    }

    @Override
    public void deletePost(Long id) {
        Post saved = postRepository.getReferenceById(id);
        updateAmountOfPosts(saved.userId,  -1);
        postRepository.deleteById(id);
    }

    @Override
    public PostRes updatePost(Long id, PostReq postReq) {
        Post saved = postRepository.getReferenceById(id);
        saved.setText(postReq.getText());
        return postMapper.toResponse(postRepository.save(saved));
    }

    private void updateAmountOfPosts(Number userId, Integer amount) {
        UpdateUsersPostsReq req = new UpdateUsersPostsReq(amount);
        String url = userServiceProperties.origin + "/users/%s/posts".formatted(userId);
        System.out.println(url);
        restTemplate.put(url, req);
    }
}
