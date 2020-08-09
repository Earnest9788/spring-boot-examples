package com.example.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() { 
        return "hello"; 
    } 
    
    @RequestMapping(value = "/hello1")
    public ModelAndView hell() {
        ModelAndView view = new ModelAndView();
        view.setViewName("hello1");
        view.addObject("name", "Hello1");
        return view;
    }
}
