package com.koes.local_llm_spring_boot.controller;

import com.koes.local_llm_spring_boot.model.LlamaResponse;
import com.koes.local_llm_spring_boot.service.LlamaAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class LlamaRestController {
    private final LlamaAiService llamaAiService;

    @Autowired
    public LlamaRestController(LlamaAiService llamaAiService) {
      this.llamaAiService = llamaAiService;
    }

    @GetMapping("api/v1/ai/generate")
    public ResponseEntity<LlamaResponse> generate(
        @RequestParam(value = "promptMessage", defaultValue = "Why is the sky blue?")
            String promptMessage) {
      final LlamaResponse aiResponse = llamaAiService.generateMessage(promptMessage);
      return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }

    @GetMapping("api/v1/ai/generate/joke/{topic}")
    public ResponseEntity<LlamaResponse> generateJoke(@PathVariable String topic) {
      final LlamaResponse aiResponse = llamaAiService.generateJoke(topic);
      return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }

    @GetMapping("embbeding/test")
    public Map<String, Object> getEmbbeding(
            @RequestParam(value = "promptMessage", defaultValue = "Why is the sky blue?")
            String promptMessage){
        Map<String, Object> result = llamaAiService.generateEmbeddingVector(promptMessage);
        return result;
    }
}