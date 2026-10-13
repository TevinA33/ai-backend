package com.aibackend.ai_backend.ingestion.wiki;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WikiIngestionServiceTest {

    @Autowired
    private WikiIngestionService wikiIngestionService;

    @Test
    public void ingestWikiFiles_forLearning() throws Exception {
        wikiIngestionService.ingestWikiFiles();
    }
}
