package com.huinong.controller;

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
        List<HallMeun> hallMeunList = hallMeunService.selectByDeleteFlgKey(1);
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
