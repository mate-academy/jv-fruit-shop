package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeReport(String report, String path) {
        if (path == null) {
            throw new IllegalArgumentException("Path must not be null");
        }
        File file = new File(path);
        try {
            Files.write(file.toPath(),report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + path, e);
        }
    }
}
