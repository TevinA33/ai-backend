package com.aibackend.ai_backend.ingestion.pdf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PdfIngestionServiceTest {

    @Autowired
    PdfIngestionService pdfIngestionService;

    @Test
    void ingestPdfs_forLearning() throws Exception {
        pdfIngestionService.ingestPdfs();
    }
}
