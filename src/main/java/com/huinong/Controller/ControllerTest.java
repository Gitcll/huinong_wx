package com.huinong.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ControllerTest {

    @GetMapping("index")
    public String test(){
        return "index";
    }

    @PostMapping("count")
    public String count(@RequestBody Map<String, Integer> jsonDate) {

        String date = "";
        Integer num1 = jsonDate.get("num1");
        Integer num2 = jsonDate.get("num2");
        date = String.valueOf(num1 + num2);
        return date;
    }
}
