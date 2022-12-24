package com.huinong.service.impl;

import com.huinong.mapper.UsersMapper;
import com.huinong.pojo.Users;
import com.huinong.service.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users selectByIdUsers(String userName) {
        if(StringUtils.isNotEmpty(userName)){
            Users users = usersMapper.selectByPrimaryKey(userName);
            return users;
        }
        return null;
    }

    public int registerUsers(Users users) {
        return usersMapper.insert(users);
    }
}
