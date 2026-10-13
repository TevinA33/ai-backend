package com.aibackend.ai_backend.ingestion.wiki;

import com.aibackend.ai_backend.ingestion.model.IngestedDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class WikiIngestionService {
    private static final String WIKI_DIRECTORY = "data/wiki";

    public List<IngestedDocument> ingestWikiFiles() throws Exception {
        File[] markdownFiles = new File(WIKI_DIRECTORY).listFiles();

        List<IngestedDocument> ingestedDocuments = new ArrayList<>();

        for (File file : markdownFiles) {
            ingestedDocuments.add(ingestSingleFile(file));
        }

        return ingestedDocuments;
    }

    private IngestedDocument ingestSingleFile(File file) throws IOException {
        log.info("Ingesting wiki file: {}", file.getName());

        String content = Files.readString(file.toPath());

        log.info("---- Wiki Content ({}) ----", file.getName());
        log.info(content);

        return new IngestedDocument(
                "WIKI",
                content,
                Map.of("fileName", file.getName()).toString()
        );
    }
}
