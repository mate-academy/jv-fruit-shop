package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeReportToFile(String fileName, String report) {
        try {
            Files.write(new File(fileName).toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cannot modify or write to " + fileName + " file", e);
        }
    }
}
