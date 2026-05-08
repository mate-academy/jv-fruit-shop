package service.impl;

import service.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String report, String path) {
        try {
            Files.writeString(Path.of(path), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + path, e);
        }
    }
}
