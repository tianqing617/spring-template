package top.smartliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.smartliu.service.AccountService;

import java.io.IOException;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll() throws IOException {
        System.out.println("findAll");
        accountService.findAll();
        return "findAll";
    }
}
