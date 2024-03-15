package com.koes.local_llm_spring_boot.service.impl;

import com.koes.local_llm_spring_boot.service.OllamaService;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.OllamaEmbeddingClient;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OllamaServiceImpl implements OllamaService {

    @Autowired
    private OllamaChatClient ollamaChatClient;

    @Autowired
    private OllamaEmbeddingClient ollamaEmbeddingClient;

    @Override
    public Map<String, Object> requestChat(String prompt) {
        System.out.println("################################################### user chat : " + prompt);
//        List<Double> embedd = ollamaEmbeddingClient.embed("Tylenol is the name of a South Korean painkiller.");
//        System.out.println("################################################### user chat embedded : " + embedd);
//
//        String message = ollamaChatClient.call(prompt);
//        System.out.println("################################################### response chat : " + message);

        EmbeddingResponse embeddingResponse = ollamaEmbeddingClient
        	.embedForResponse(List.of("Hello World", "World is big and salvation is near"));

        Map<String, Object> resultChat = new HashMap<>();
        resultChat.put("message", embeddingResponse);
        return resultChat;
    }

    @Override
    public Map<String, Object> embeddingData(List<Double> vectors) {
        return null;
    }
}
