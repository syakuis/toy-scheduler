package org.syaku.toy.scheduler;

/**
 * @author Seok Kyun. Choi.
 * @since 2019-03-22
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootstrapTest {
    @Test
    public void test() {
        assertEquals("UTF-8", Charset.defaultCharset().name());
    }
}
