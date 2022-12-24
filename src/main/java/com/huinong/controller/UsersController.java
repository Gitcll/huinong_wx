package com.huinong.controller;

import com.huinong.pojo.Users;
import com.huinong.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RequestMapping("users")
@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("register")
    public String regisgerUsers(@RequestBody Map<String, String> userMap){
        if (Objects.nonNull(userMap) && userMap.size() > 0) {
            String userName = userMap.get("userName");
            String passWord = userMap.get("passWord");
            Users users = usersService.selectByIdUsers(userName);
            if(Objects.nonNull(users)){
                return "此用户已存在";
            }else {
                Users registerUser = new Users();
                registerUser.setUsername(userName);
                registerUser.setPassword(passWord);
                int i = usersService.registerUsers(registerUser);
                if(i == 0){
                    return "注册失败";
                }else {
                    return "success";
                }
            }
        }
        return "";
    }

    @PostMapping("login")
    public String loginUsers(@RequestBody Map<String, String> userMap){
        if (Objects.nonNull(userMap) && userMap.size() > 0) {
            String userName = userMap.get("userName");
            String passWord = userMap.get("passWord");
            Users users = usersService.selectByIdUsers(userName);
            if (Objects.nonNull(users)) {
                return "success";
            }else {
                return "请先注册";
            }
        }
        return "";
    }


}
