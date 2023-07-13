package com.example.controller;

import com.example.dao.ArticleMapper;
import com.example.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.transform.Templates;
import java.util.Calendar;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping("/login")
    public String toLoginPage(Model model){
//        model的使用:halo相当于key,将key在templates中替换为value的值
        model.addAttribute("halo","halo thymeleaf");
        model.addAttribute("baidu","https://www.baidu.com");
        model.addAttribute("currentYear",Calendar.getInstance().get(Calendar.YEAR));

        List<Article> articleList = articleMapper.selectAll();
        model.addAttribute("allArticles",articleList);

//        转发到templates页面:前缀+字符串+后缀(templates+login+.html),注意不能@RespondBody
        return "login";
    }
}
