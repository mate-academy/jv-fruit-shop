package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriterMapToCsvServiceImpl implements WriterService {

    @Override
    public void writeReport(String data, String fileName) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("File " + fileName + " not found");
        }
    }
}
