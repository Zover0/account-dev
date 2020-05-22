package com.zover.controller;

import com.zover.pojo.Account;
import com.zover.pojo.bo.AccountBO;
import com.zover.pojo.bo.QueryAccountBO;
import com.zover.pojo.vo.AccountVO;
import com.zover.service.AccountService;
import com.zover.utils.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.im.InputMethodManager;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/hello")
    public Object testHello(){
        return "hello";
    }

    @GetMapping("/test")
    public Object test(){
        return "test";
    }

    @PostMapping("/queryAccount")
    public IMOOCJSONResult queryAccount(QueryAccountBO queryAccountBO){
        List<Account> list = accountService.queryAccount(queryAccountBO);
        return IMOOCJSONResult.ok(list);
    }

    @PostMapping("/addAccount")
    public IMOOCJSONResult addAccount(AccountBO accountBO){

        if (StringUtils.isBlank(accountBO.getDate()) ||
                StringUtils.isBlank(accountBO.getRemark()) ||
                accountBO.getMoney() == null){
            return IMOOCJSONResult.errorMsg("有数据为空");
        }

        accountService.addAccount(accountBO);
        return IMOOCJSONResult.ok();
    }

    @PostMapping("/editAccount")
    public IMOOCJSONResult editAccount(AccountBO accountBO){
        accountService.editAccount(accountBO);
        return IMOOCJSONResult.ok();
    }

    @PostMapping("/deleteAccount")
    public IMOOCJSONResult deleteAccount(String id){
        if(StringUtils.isBlank(id)){
            return IMOOCJSONResult.errorMsg("主键为空");
        }
        accountService.deleteAccount(id);
        return IMOOCJSONResult.ok();
    }

}
