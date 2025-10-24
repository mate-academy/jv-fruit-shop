package service.impl;

import interfaces.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String report, String reportPath) {
        if (!report.isEmpty() && !reportPath.isEmpty()) {
            Path path = Path.of(reportPath);
            try {
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }

                Files.writeString(
                        path,
                        report,
                        StandardOpenOption.TRUNCATE_EXISTING,
                        StandardOpenOption.CREATE);
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file: " + reportPath, e);
            }
        } else {
            throw new IllegalArgumentException("Report or Path can't be empty or null.");
        }
    }
}
