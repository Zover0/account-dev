package com.zover.controller;

import com.zover.pojo.User;
import com.zover.pojo.bo.UserBO;
import com.zover.service.UserService;
import com.zover.utils.CookieUtils;
import com.zover.utils.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public IMOOCJSONResult login(UserBO userBO, HttpServletRequest httpRequest, HttpServletResponse httpResponse){

        if(StringUtils.isBlank(userBO.getName())){
            return IMOOCJSONResult.errorMsg("用户名为空");
        }
        if(StringUtils.isBlank(userBO.getPassword())){
            return IMOOCJSONResult.errorMsg("密码为空");
        }

        User user = userService.login(userBO);
        if(user != null){
            String token = UUID.randomUUID().toString().trim();
            CookieUtils.setCookie(httpRequest,httpResponse,"userToken",token,true);
            return IMOOCJSONResult.ok();
        }else{
            return IMOOCJSONResult.errorMsg("账号密码错误");
        }

    }

}
