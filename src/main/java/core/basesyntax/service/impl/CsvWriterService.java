package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterService implements WriterService {
    @Override
    public void write(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))
        ) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
    }
}
