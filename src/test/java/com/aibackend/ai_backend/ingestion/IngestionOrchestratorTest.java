package com.aibackend.ai_backend.ingestion;

import com.aibackend.ai_backend.ingestion.model.IngestedDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class IngestionOrchestratorTest {

    @Autowired
    IngestionOrchestrator ingestionOrchestrator;

    @Test
    void ingestAll() throws Exception {
        List<IngestedDocument> docs = ingestionOrchestrator.ingestAll();

        System.out.println("Total docs = " + docs.size());

        docs.forEach(doc -> {
            System.out.println("SOURCE = " + doc.getSource());
            System.out.println(doc.getContent());
            System.out.println("----");
        });
    }
}
