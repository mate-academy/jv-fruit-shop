package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements WriterService {

    @Override
    public void write(String generatedData, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(generatedData);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file. " + e);
        }
    }
}
