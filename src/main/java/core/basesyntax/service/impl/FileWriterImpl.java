package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String resultingReport, String fileName) {
        File file = new File(fileName);
        try {
            Files.write(file.toPath(), resultingReport.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName);
        }
    }
}
