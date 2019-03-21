package org.syaku.toy.scheduler.web.comment.controller;

/**
 * @author Seok Kyun. Choi.
 * @since 2019-03-22
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.syaku.toy.web.comment.domain.CommentEntity;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CommentRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Before
    public void setup() {
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void save() throws Exception {
        mockMvc.perform(post("/api/comment")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(
                CommentEntity.builder()
                    .content("테스트입니다.")
                    .build()
            )))
            .andExpect(status().isOk());
    }

    @Test
    public void list() throws Exception {
        mockMvc.perform(get("/api/comment"))
            .andExpect(status().isOk());
    }
}
