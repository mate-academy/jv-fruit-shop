package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {
    private static final String FILE_REPORT_PATH = "src/main/resources/fileReport.csv";

    @Override
    public void writeToFile(String report) {
        File file = new File(FILE_REPORT_PATH);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file!", e);
        }
    }
}
