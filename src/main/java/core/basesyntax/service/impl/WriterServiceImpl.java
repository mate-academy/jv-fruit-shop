package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToCsv(String generatedReport, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(generatedReport);
        } catch (IOException e) {
            throw new RuntimeException("File path is wrong", e);
        }
    }
}
