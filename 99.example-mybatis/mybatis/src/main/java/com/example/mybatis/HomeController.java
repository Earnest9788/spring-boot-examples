package com.example.mybatis;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.mybatis.dao.IBbsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    
    @Autowired
    private IUserDao userDao;

    @Autowired
    private IBbsDao bbsDao;

    @RequestMapping("/")
    public String root() throws Exception {
        return "redirect:list";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userListPage(Model model) {
        model.addAttribute("users", userDao.list());

        return "/userlist";
    }

    @RequestMapping("/list")
    public String bbslistPage(Model model) {
        model.addAttribute("list", bbsDao.listDao());

        int nTotalCount = bbsDao.articleCount();
        System.out.println("Count : " + nTotalCount);

        return "/list";
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");
        model.addAttribute("dto", bbsDao.viewDao(sId));

        return "/view";
    }

    @RequestMapping("/writeForm")
    public String writeForm() {
        return "/writeForm";
    }
    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model) {

        String sName = request.getParameter("writer");
        String sTitle = request.getParameter("title");
        String sContent = request.getParameter("content");

        Map<String, String> map = new HashMap<String, String>();
        map.put("_name", sName);
        map.put("_title", sTitle);
        map.put("_content", sContent);

        int nResult = bbsDao.wirteDao(map);
        System.out.println("Write : " + nResult);

        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        bbsDao.delteDao(request.getParameter("id"));

        return "redirect:list";
    }

}