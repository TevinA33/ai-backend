package com.aibackend.ai_backend.ingestion.pdf;

import com.aibackend.ai_backend.ingestion.model.IngestedDocument;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class PdfIngestionService {

    private static final String PDF_DIRECTORY = "data/pdfs";

    public List<IngestedDocument> ingestPdfs() throws Exception{
        File[] pdfFiles = new File(PDF_DIRECTORY).listFiles();

        List<IngestedDocument> docs = new ArrayList<>();

        for (File pdfFile : Objects.requireNonNull(pdfFiles)) {
            docs.add(ingestSinglePdf(pdfFile));
        }

        return docs;
    }

    private IngestedDocument ingestSinglePdf(File pdfFile) throws IOException {
        log.info("Ingesting PDF: {}", pdfFile.getName());

        try (PDDocument document = PDDocument.load(pdfFile)) {
            PDFTextStripper stripper = new PDFTextStripper();

            String text = stripper.getText(document);

            log.info("---- Extracted Text ({}) ----", pdfFile.getName());
            log.info(text);

            return new IngestedDocument(
                    "PDF",
                    text,
                    Map.of("fileName", pdfFile.getName()).toString()
            );
        }
    }
}
