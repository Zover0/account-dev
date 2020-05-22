package com.zover.service;

import com.zover.pojo.User;
import com.zover.pojo.bo.UserBO;

public interface UserService {

    public User login(UserBO userBO);

}
