package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.transform.Templates;
import java.util.Calendar;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String toLoginPage(Model model){
//        model的使用:halo相当于key,将key在templates中替换为value的值
        model.addAttribute("halo","halo thymeleaf");
        model.addAttribute("currentYear",Calendar.getInstance().get(Calendar.YEAR));
//        转发到templates页面:前缀+字符串+后缀(templates+login+.html),注意不能@RespondBody
        return "login";
    }
}
