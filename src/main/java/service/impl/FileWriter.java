package service.impl;

import java.io.IOException;
import service.Writer;

public class FileWriter implements Writer {
    @Override
    public void writeToFile(String fileName, String stringReport) {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName);) {
            writer.write(stringReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName, e);
        }
    }
}
