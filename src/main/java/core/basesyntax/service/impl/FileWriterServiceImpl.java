package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String report, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + fileName, e);
        }
    }
}
