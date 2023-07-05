package core.basesyntax.service;

import java.io.IOException;
import java.util.List;

public class FileWriterImpl implements FileWriter {

    public void writeToFile(List<String> lines, String fileName) {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            for (String l : lines) {
                writer.write(l + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fileName, e);
        }
    }
}
