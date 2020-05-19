package com.zover.service;

import com.zover.pojo.bo.AccountVO;
import com.zover.pojo.vo.AccountBO;

import java.util.List;

public interface AccountService {

    public List<AccountVO> queryAccount(AccountBO accountBO);

}
