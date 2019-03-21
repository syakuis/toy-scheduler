package org.syaku.toy.web.comment.repository;

import org.springframework.data.repository.Repository;
import org.syaku.toy.web.comment.domain.CommentEntity;

import java.util.List;

/**
 * @author Seok Kyun. Choi.
 * @since 2019-03-21
 */
public interface CommentRepository extends Repository<CommentEntity, Long> {
    CommentEntity save(CommentEntity commentEntity);
    List<CommentEntity> findAll();
}
