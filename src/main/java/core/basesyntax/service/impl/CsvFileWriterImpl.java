package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class CsvFileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String filePath, String report) {
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file));) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file \"" + file + "\"", e);
        }
    }
}
