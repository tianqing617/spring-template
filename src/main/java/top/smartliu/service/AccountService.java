package top.smartliu.service;

import java.io.IOException;
import java.util.List;
import top.smartliu.domain.Account;

public interface AccountService {
    public List<Account> findAll() throws IOException;

    public int save(Account account) throws IOException;
}
