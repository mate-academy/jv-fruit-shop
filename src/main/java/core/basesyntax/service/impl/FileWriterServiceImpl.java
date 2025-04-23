package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String reportContent, String filePath) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8)) {
                bufferedWriter.write(reportContent);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}

