package com.koes.local_llm_spring_boot.service.impl;

import com.koes.local_llm_spring_boot.service.HuggingFaceService;
import org.springframework.ai.huggingface.HuggingfaceChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HuggingFaceServiceImpl implements HuggingFaceService {

    private HuggingfaceChatClient huggingfaceChatClient;

    @Autowired
    public HuggingFaceServiceImpl(HuggingfaceChatClient huggingfaceChatClient) {
        huggingfaceChatClient = new HuggingfaceChatClient("","");
        this.huggingfaceChatClient = huggingfaceChatClient;
    }

    @Override
    public Map<String, Object> generateMessage(String message) {
//        HuggingfaceChatClient client = new HuggingfaceChatClient("", "");
        Map<String, Object> result = new HashMap<>();
        result.put("message", huggingfaceChatClient.call(message));
        return result;
    }

    @Override
    public Map<String, Object> generateEmbedded(String message) {
//        final List<Double> resultVector = huggingfaceChatClient.
        Map<String, Object> result = new HashMap<>();

        return null;
    }
}
