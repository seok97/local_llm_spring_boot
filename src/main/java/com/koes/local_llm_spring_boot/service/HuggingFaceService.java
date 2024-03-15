package com.koes.local_llm_spring_boot.service;

import java.util.Map;

public interface HuggingFaceService {
    Map<String, Object> generateMessage(String message);

    Map<String, Object> generateEmbedded(String message);
}