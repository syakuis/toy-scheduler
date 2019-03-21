package org.syaku.toy.web.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.syaku.toy.web.comment.domain.CommentEntity;
import org.syaku.toy.web.comment.model.Comment;
import org.syaku.toy.web.comment.service.CommentService;

import java.util.List;

/**
 * @author Seok Kyun. Choi.
 * @since 2019-03-21
 */
@RestController
@RequestMapping("/api/comment")
public class CommentRestController {
    private final CommentService commentService;

    @Autowired
    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<CommentEntity>> list() {
        return new ResponseEntity<>(commentService.getCommentEntites(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommentEntity> save(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.setCommentEntity(comment), HttpStatus.OK);
    }
}
