package org.syaku.toy.web.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.syaku.toy.web.comment.domain.CommentEntity;
import org.syaku.toy.web.comment.model.Comment;
import org.syaku.toy.web.comment.repository.CommentRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Seok Kyun. Choi.
 * @since 2019-03-21
 */
@Service
@Transactional
public class CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentEntity setCommentEntity(Comment comment) {
        return commentRepository.save(CommentEntity.builder().content(comment.getContent()).build());
    }

    public List<CommentEntity> getCommentEntites() {
        return commentRepository.findAll();
    }
}
