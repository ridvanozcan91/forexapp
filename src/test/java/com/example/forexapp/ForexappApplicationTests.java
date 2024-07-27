package com.example.forexapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "fixer.api.url=http://data.fixer.io"
})
class ForexappApplicationTests {

    @Test
    void contextLoads() {
    }

}
