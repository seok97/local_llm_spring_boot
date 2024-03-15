package com.koes.local_llm_spring_boot.service;

import java.util.List;
import java.util.Map;

public interface OllamaService {
    Map<String, Object> requestChat(String prompt);

    Map<String, Object> embeddingData(List<Double> vectors);
}
