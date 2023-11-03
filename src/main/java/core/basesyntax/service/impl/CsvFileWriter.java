package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriter implements FileWriterService {
    @Override
    public boolean write(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file with path: " + filePath, e);
        }
    }
}
