package com.aibackend.ai_backend.ingestion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IngestedDocument {

    private String source; //PDF, WIKI, DB
    private String content;
    private String metadata;
}
