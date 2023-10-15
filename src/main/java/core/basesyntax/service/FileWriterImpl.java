package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(File file, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file))) {
            bufferedWriter.write(report);
        } catch (IOException ioException) {
            throw new RuntimeException("Cannot write data to file: " + file, ioException);
        }
    }
}
