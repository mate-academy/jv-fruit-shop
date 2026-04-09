package service.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String path) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(path))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Error writing file", e);
        }
    }
}
