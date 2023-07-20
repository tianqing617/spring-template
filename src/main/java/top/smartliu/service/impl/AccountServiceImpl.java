package top.smartliu.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartliu.domain.Account;
import top.smartliu.mapper.AccountMapper;
import top.smartliu.service.AccountService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    // spring集成mybatis的方式
    @Override
    public List<Account> findAll() throws IOException{
        System.out.println("service findAll");

        return accountMapper.findAll();
    }

    // spring未集成mybatis的方式
    @Override
    public int save(Account account) throws IOException {
        SqlSession sqlSession = getSqlSession();

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        int count = mapper.save(account);
        sqlSession.commit();
        return count;
    }

    private SqlSession getSqlSession() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获取SqlSession对象
        return sqlSessionFactory.openSession();
    }
}
