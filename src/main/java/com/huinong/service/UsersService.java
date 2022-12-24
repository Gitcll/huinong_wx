package com.huinong.service;

import com.huinong.mapper.UsersMapper;
import com.huinong.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;

public interface UsersService {
    Users selectByIdUsers(String userName);
    int registerUsers(Users users);
}
