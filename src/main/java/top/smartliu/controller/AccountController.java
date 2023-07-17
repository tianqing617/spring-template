package top.smartliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.smartliu.domain.Account;
import top.smartliu.service.AccountService;
import java.util.List;
import java.io.IOException;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll() throws IOException {
        List<Account> accountList = accountService.findAll();
        System.out.println(accountList);
        return "findAll";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save() throws IOException {
        Account account = new Account();
        account.setName("wangwu");
        account.setMoney(200.00);

        int count = accountService.save(account);
        System.out.print("影响行数：");
        System.out.println(count);
        return "save";
    }
}
