package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String pathFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(pathFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Report cannot be write to file " + pathFile, e);
        }
    }
}
