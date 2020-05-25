package com.zover.service.Impl;

import com.zover.mapper.AccountMapper;
import com.zover.pojo.Account;
import com.zover.pojo.bo.AccountBO;
import com.zover.pojo.vo.AccountVO;
import com.zover.pojo.bo.QueryAccountBO;
import com.zover.service.AccountService;
import com.zover.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Account> queryAccount(@RequestBody QueryAccountBO queryAccountBO){
        Example accountExample = new Example(Account.class);
        Example.Criteria criteria = accountExample.createCriteria();

        accountExample.setOrderByClause("date desc");

        if(StringUtils.isNoneBlank(queryAccountBO.getRemark())){
            criteria.andLike("remark","%"+queryAccountBO.getRemark()+"%");
        }
        if(StringUtils.isNoneBlank(queryAccountBO.getStartDate())){
            criteria.andGreaterThan("date",queryAccountBO.getStartDate());
        }
        if(StringUtils.isNoneBlank(queryAccountBO.getEndDate())){
            criteria.andLessThan("date",queryAccountBO.getEndDate());
        }
        if(queryAccountBO.getStartMoney() != null){
            criteria.andGreaterThan("money",queryAccountBO.getStartMoney());
        }
        if(queryAccountBO.getEndMoney() != null){
            criteria.andLessThan("money",queryAccountBO.getEndMoney());
        }


        List<Account> list = accountMapper.selectByExample(accountExample);

        return list;

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addAccount(@RequestBody AccountBO accountBO) {
        Account account = new Account();
        account.setDate(DateUtil.stringToDate(accountBO.getDate()));
        account.setMoney(accountBO.getMoney());
        account.setCreatetime(new Date());
        account.setCreator(accountBO.getCreator());
        account.setRemark(accountBO.getRemark());

        accountMapper.insert(account);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void editAccount(@RequestBody AccountBO accountBO) {
        Account account = new Account();
        account.setId(accountBO.getId());
        account.setDate(DateUtil.stringToDate(accountBO.getDate()));
        account.setMoney(accountBO.getMoney());
        account.setRemark(accountBO.getRemark());
        accountMapper.updateByPrimaryKeySelective(account);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteAccount(@RequestParam String id) {
        accountMapper.deleteByPrimaryKey(id);
    }

}
