package com.jojoidu.book.springboot.service.posts;

import com.jojoidu.book.springboot.domain.posts.Posts;
import com.jojoidu.book.springboot.domain.posts.PostsRepository;
import com.jojoidu.book.springboot.web.dto.PostsResponseDto;
import com.jojoidu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoidu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // lombok을 쓰는 이유 클래스의 의존성 관계가 변경될때마다 생성자 코드를 계속해서 수정하는 번거로움을 해결
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }


    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(posts);

    }

    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }
}
