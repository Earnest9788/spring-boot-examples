package com.example.mvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {
    
    // CASE1
    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello_mock() throws Exception {
        mockMvc
            .perform(get("/hello"))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(content().string(containsString("kiwoon")))
            .andExpect(view().name("hello"))
            .andExpect(model().attribute("name", is("kiwoon")));
    }

    // CASE2: HTML 컨텐츠에 특화된 테스트 케이스 방법.
    @Autowired
    WebClient webClient;

    @Test
    public void hello_unit() throws Exception {
        HtmlPage page = webClient.getPage("/hello");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualToIgnoringCase("kiwoon");
    }

}