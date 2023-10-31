package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String path, String date) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path))) {
            bufferedWriter.write(date);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create or write to file: " + path, e);
        }
    }
}
