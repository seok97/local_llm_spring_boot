package com.koes.local_llm_spring_boot.service.impl;

import com.koes.local_llm_spring_boot.model.LlamaResponse;
import com.koes.local_llm_spring_boot.service.LlamaAiService;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LlamaAiServiceImpl implements LlamaAiService {

    private final ChatClient chatClient;

    private final EmbeddingClient embeddingClient;

    @Autowired
    public LlamaAiServiceImpl(ChatClient ollamaChatClient, EmbeddingClient embeddingClient){
        this.chatClient = ollamaChatClient;
        this.embeddingClient = embeddingClient;
    }

    @Override
    public LlamaResponse generateMessage(String promptMessage) {
        final String llamaMessage = chatClient.call(promptMessage);
        return new LlamaResponse().setMessage(llamaMessage);
    }

    @Override
    public LlamaResponse generateJoke(String topic) {
        final String llamaMessage = chatClient.call(String.format("Tell me a joke about %s\", topic"));
        return new LlamaResponse().setMessage(llamaMessage);
    }

    @Override
    public Map<String, Object> generateEmbeddingVector(String prompt) {
        final List<Double> resultVector = embeddingClient.embed(prompt);
        Map<String, Object> result = new HashMap<>();
        result.put("result", resultVector);
        return result;
    }
}
