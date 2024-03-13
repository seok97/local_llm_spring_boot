package com.koes.local_llm_spring_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {

    @GetMapping("/sample/gettest")
    public Map<String, Object> getTest() {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "테스트 용 get 요청 반환");
        return result;
    }
}