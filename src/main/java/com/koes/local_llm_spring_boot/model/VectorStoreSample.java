package com.koes.local_llm_spring_boot.model;

import lombok.Data;
import java.util.List;

@Data
public class VectorStoreSample {
    Integer id;
    String content;
    String metadata;
    List<Double> embedding;

    public Integer getId() {
        return id;
    }

    public VectorStoreSample setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public VectorStoreSample setContent(String content) {
        this.content = content;
        return this;
    }

    public String getMetadata() {
        return metadata;
    }

    public VectorStoreSample setMetadata(String metadata) {
        this.metadata = metadata;
        return this;
    }

    public List<Double> getEmbedding() {
        return embedding;
    }

    public VectorStoreSample setEmbedding(List<Double> embedding) {
        this.embedding = embedding;
        return this;
    }
}
