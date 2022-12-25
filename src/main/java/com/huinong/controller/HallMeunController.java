package com.huinong.controller;

import com.huinong.common.Constant;
import com.huinong.pojo.HallMeun;
import com.huinong.service.HallMeunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("hall")
public class HallMeunController {

    @Autowired
    private HallMeunService hallMeunService;

    @GetMapping("meun")
    public List<HallMeun> meun(ModelAndView modelAndView){
        List<HallMeun> hallMeunList = hallMeunService.selectByDeleteFlgKey(Constant.DELETE_FLG, Constant.MEUN_URL_HALL);
        modelAndView.addObject("hallMeun", hallMeunList);
        return hallMeunList;
    }

    @GetMapping("meun_nong")
    public List<HallMeun> meun_nong(ModelAndView modelAndView){
        List<HallMeun> hallMeunList = hallMeunService.selectByDeleteFlgKey(Constant.DELETE_FLG, Constant.MEUN_URL_NONG);
        modelAndView.addObject("hallMeun", hallMeunList);
        return hallMeunList;
    }

    @GetMapping("meun_nongzi")
    public List<HallMeun> meun_nongzi(ModelAndView modelAndView){
        List<HallMeun> hallMeunList = hallMeunService.selectByDeleteFlgKey(Constant.DELETE_FLG, Constant.MEUN_URL_NONG_ZI);
        modelAndView.addObject("hallMeun", hallMeunList);
        return hallMeunList;
    }

    @GetMapping("meun_nongfu")
    public List<HallMeun> meun_nongfu(ModelAndView modelAndView){
        List<HallMeun> hallMeunList = hallMeunService.selectByDeleteFlgKey(Constant.DELETE_FLG, Constant.MEUN_URL_NONG_FU);
        modelAndView.addObject("hallMeun", hallMeunList);
        return hallMeunList;
    }
}
/**
 List<HallMeun> selectByDeleteFlgKey(Integer deleteflg);
  <select id="selectByDeleteFlgKey" parameterType="java.lang.Integer" resultMap="ResultMapWithBLOBs">
    select
    <include refid="Base_Column_List" />
    ,
    <include refid="Blob_Column_List" />
    from hallmeun
    where
    deleteflg = #{deleteflg,jdbcType=INTEGER}
  </select>
*/
