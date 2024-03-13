package com.koes.local_llm_spring_boot.service.impl;

import com.koes.local_llm_spring_boot.model.LlamaResponse;
import com.koes.local_llm_spring_boot.service.LlamaAiService;
import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LlamaAiServiceImpl implements LlamaAiService {

    private final ChatClient chatClient;

    @Autowired
    public LlamaAiServiceImpl(ChatClient chatClient){
        this.chatClient = chatClient;
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
}
