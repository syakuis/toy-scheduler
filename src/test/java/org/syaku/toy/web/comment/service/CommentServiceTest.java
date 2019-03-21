package org.syaku.toy.web.comment.service;

/**
 * timezone 잘못되어 날짜가 정확하지 않음. - Application timezone 추가하여 해결.
 * @author Seok Kyun. Choi.
 * @since 2019-03-21
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.syaku.toy.web.comment.model.Comment;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    @Test
    public void save() {
        commentService.setCommentEntity(Comment.builder().content("테스트").build());
    }

    @Test
    public void select() {
        commentService.getCommentEntites();
    }
}
