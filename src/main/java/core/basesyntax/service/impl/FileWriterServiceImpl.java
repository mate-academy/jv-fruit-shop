package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String report, String fileName) {
        if (report == null || report.isEmpty()) {
            throw new IllegalArgumentException("Can't write empty report to file");
        }
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Can't write report to empty file name");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + fileName, e);
        }
    }
}
