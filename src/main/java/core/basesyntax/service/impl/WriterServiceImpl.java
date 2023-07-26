package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String filePath, List<String> reportData) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String line : reportData) {
                writer.append(line);
                writer.append(System.lineSeparator());
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + filePath, e);
        }
    }
}
