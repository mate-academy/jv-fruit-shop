package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String report, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + fileName, e);
        }
    }
}
