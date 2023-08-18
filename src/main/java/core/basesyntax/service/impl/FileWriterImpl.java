package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeToFile(String filePath, String content) {
        if (filePath == null) {
            throw new RuntimeException("File path can`t be null!");
        } else if (content == null) {
            throw new RuntimeException("Content can`t be null!");
        }
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write content to file by path: " + filePath, e);
        }
    }
}
