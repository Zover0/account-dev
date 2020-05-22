package com.zover.service.Impl;

import com.zover.mapper.UserMapper;
import com.zover.pojo.User;
import com.zover.pojo.bo.UserBO;
import com.zover.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User login(UserBO userBO) {
        Example userExample = new Example(User.class);
        Example.Criteria criteria =  userExample.createCriteria();

        criteria.andEqualTo("name",userBO.getName());
        criteria.andEqualTo("password",userBO.getPassword());

        return userMapper.selectOneByExample(userExample);
    }
}
