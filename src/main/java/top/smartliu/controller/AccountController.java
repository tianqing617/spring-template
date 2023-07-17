package top.smartliu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll() {
        System.out.println("findAll");
        return "findAll";
    }
}
