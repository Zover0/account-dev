package com.zover.service;

import com.zover.pojo.Account;
import com.zover.pojo.bo.AccountBO;
import com.zover.pojo.vo.AccountVO;
import com.zover.pojo.bo.QueryAccountBO;

import java.util.List;

public interface AccountService {

    public List<Account> queryAccount(QueryAccountBO queryAccountBO);

    public void addAccount(AccountBO accountBO);

    public void editAccount(AccountBO accountBO);

    public void deleteAccount(String id);
}
