package com.koes.local_llm_spring_boot.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LlamaResponse {
    private String message;
}
