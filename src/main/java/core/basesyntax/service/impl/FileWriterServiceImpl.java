package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void writeIntoFile(String report, String path) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(path))) {
            writer.write(report);
        } catch (IOException exception) {
            throw new RuntimeException("Error writing report to file at path: " + path, exception);
        }
    }
}
