package core.basesyntax.service.impl;

import core.basesyntax.service.WritingFileService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WritingFileServiceImpl implements WritingFileService {
    @Override
    public void writingDataToFile(String reportData, String outputFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile, true))) {
            Files.writeString(Path.of(outputFile), "");
            bufferedWriter.write(reportData);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + outputFile, e);
        }
    }
}
