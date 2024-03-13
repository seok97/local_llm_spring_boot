package com.koes.local_llm_spring_boot.service;

import com.koes.local_llm_spring_boot.model.LlamaResponse;

public interface LlamaAiService {
    LlamaResponse generateMessage(String prompt);
    LlamaResponse generateJoke(String topic);
}