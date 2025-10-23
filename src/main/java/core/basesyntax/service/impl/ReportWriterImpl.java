package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReportWriterImpl implements ReportWriter {

    public void write(String resultingReport, String path) {
        Path filePath = Paths.get(path);
        try {
            if (filePath.getParent() != null) {
                Files.createDirectories(filePath.getParent());
            }
            try (BufferedWriter bw = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
                bw.write(resultingReport);
                bw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to path: " + path, e);
        }
    }
}
