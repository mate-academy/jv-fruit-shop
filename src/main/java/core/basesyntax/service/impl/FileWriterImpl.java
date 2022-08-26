package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeReport(String toFile, String report) {
        File reportFile = new File(toFile);
        try {
            reportFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file: " + toFile, e);
        }
        try (BufferedWriter reportWriter = new BufferedWriter(new java.io.FileWriter(reportFile))) {
            reportWriter.write(report);
            reportWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + toFile, e);
        }
    }
}
