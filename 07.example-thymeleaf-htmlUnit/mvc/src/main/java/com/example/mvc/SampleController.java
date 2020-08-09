package com.example.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    

    @GetMapping("/hello")
    public String hello(Model model) { // Model === Map 이라고 생각하면 됨.
        model.addAttribute("name", "kiwoon");
        
        // TIP: @Controller의 경우 리턴 값은 뷰를 의미한다;
        return "hello";
    }

}