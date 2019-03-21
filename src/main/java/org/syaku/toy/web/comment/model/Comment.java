package org.syaku.toy.web.comment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Seok Kyun. Choi.
 * @since 2019-03-22
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private String content;
}
