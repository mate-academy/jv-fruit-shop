package core.basesyntax.service;

import java.io.IOException;

public class FileWriter {
    public void write(String filePath, String text) {
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(filePath)) {
            fileWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }
}
