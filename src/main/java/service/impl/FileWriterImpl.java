package service.impl;

import java.io.IOException;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String fileName) {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileName, e);
        }
    }
}
