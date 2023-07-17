package top.smartliu.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;
import top.smartliu.domain.Account;
import top.smartliu.mapper.AccountMapper;
import top.smartliu.service.AccountService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public List<Account> findAll() throws IOException{
        System.out.println("service findAll");
        // return accountMapper.findAll();

        SqlSession sqlSession = getSqlSession();

        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        return mapper.findAll();
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
