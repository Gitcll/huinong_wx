package com.huinong.service;

import com.huinong.pojo.HallMeun;
import com.huinong.pojo.Users;

import java.util.List;

public interface HallMeunService {
    List<HallMeun> selectByDeleteFlgKey(Integer deleteflg, String meunurl);
}
