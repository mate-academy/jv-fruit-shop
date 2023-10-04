package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeReportToFile(String reportText, File toFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(toFile))) {
            bufferedWriter.write(reportText);
        } catch (IOException e) {
            throw new RuntimeException("can't write data to file: " + toFile);
        }
    }
}
