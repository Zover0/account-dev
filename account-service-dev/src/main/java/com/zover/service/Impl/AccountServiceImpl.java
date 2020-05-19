package com.zover.service.Impl;

import com.zover.mapper.AccountMapper;
import com.zover.pojo.Account;
import com.zover.pojo.bo.AccountVO;
import com.zover.pojo.vo.AccountBO;
import com.zover.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public List<AccountVO> queryAccount(AccountBO accountBO){
        return null;

    }

}
