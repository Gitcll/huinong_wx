package com.huinong.service.impl;

import com.huinong.mapper.HallMeunMapper;
import com.huinong.pojo.HallMeun;
import com.huinong.service.HallMeunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallMeunServiceImpl implements HallMeunService {
    @Autowired
    private HallMeunMapper hallMeunMapper;

    @Override
    public List<HallMeun> selectByDeleteFlgKey(Integer deleteflg, String meunurl) {
        if(deleteflg != null){
            List<HallMeun> hallMeunList = hallMeunMapper.selectByDeleteFlgKey(deleteflg, meunurl);
            return hallMeunList;
        }
        return null;
    }
}
