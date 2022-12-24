package com.huinong.mapper;

import com.huinong.pojo.HallMeun;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HallMeunMapper {
    int deleteByPrimaryKey(Integer no);

    int insert(HallMeun record);

    int insertSelective(HallMeun record);

    List<HallMeun> selectByDeleteFlgKey(Integer deleteflg);

    HallMeun selectByPrimaryKey(Integer no);

    int updateByPrimaryKeySelective(HallMeun record);

    int updateByPrimaryKeyWithBLOBs(HallMeun record);

    int updateByPrimaryKey(HallMeun record);
}