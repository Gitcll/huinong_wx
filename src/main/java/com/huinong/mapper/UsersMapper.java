package com.huinong.mapper;

import com.huinong.pojo.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(String username);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}