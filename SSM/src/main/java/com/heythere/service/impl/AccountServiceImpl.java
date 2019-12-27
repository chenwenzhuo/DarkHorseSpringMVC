package com.heythere.service.impl;

import com.heythere.dao.AccountDao;
import com.heythere.domain.Account;
import com.heythere.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao dao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层，查询所有账户......");
        return dao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层，保存账户......");
        dao.saveAccount(account);
    }
}
