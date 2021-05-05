package core.basesyntax.service.implementation;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public boolean writeToFile(String report, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write data to file" + fileName, e);
        }
        return true;
    }
}
