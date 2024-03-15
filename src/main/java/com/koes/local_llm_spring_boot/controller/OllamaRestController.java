package com.koes.local_llm_spring_boot.controller;

import com.koes.local_llm_spring_boot.service.OllamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OllamaRestController {

    @Autowired
    private OllamaService ollamaService;

    @GetMapping("ollama/chat/{prompt}")
    public Map<String, Object> chat(@PathVariable String prompt){
        return ollamaService.requestChat(prompt);
    }
}
