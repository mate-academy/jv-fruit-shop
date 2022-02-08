package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeReport(String fileName, String content) {
        File report = new File(fileName);
        if (report.exists()) {
            throw new RuntimeException("Overwriting the " + fileName);
        }
        try {
            report.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create the file: " + fileName, e);
        }
        try {
            Files.write(report.toPath(), content.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileName, e);
        }
    }
}
