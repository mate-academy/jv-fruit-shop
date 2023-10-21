package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements core.basesyntax.service.FileWriter {
    @Override
    public void writeToFile(File file, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(report);
        } catch (IOException ioException) {
            throw new RuntimeException("Cannot write data to file: " + file, ioException);
        }
    }
}
