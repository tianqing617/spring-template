package top.smartliu.service.impl;

import top.smartliu.domain.Account;
import top.smartliu.service.AccountService;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    @Override
    public List<Account> findAll() {
        System.out.println("service findAll");
        List<Account> list = new ArrayList<>();
        return list;
    }
}
