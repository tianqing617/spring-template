package top.smartliu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartliu.domain.Account;
import top.smartliu.mapper.AccountMapper;
import top.smartliu.service.AccountService;

import java.util.ArrayList;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        System.out.println("service findAll");
        return accountMapper.findAll();
    }
}
