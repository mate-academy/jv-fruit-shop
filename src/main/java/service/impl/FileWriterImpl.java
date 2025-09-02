package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Invalid file name");
        }
        if (data == null) {
            throw new IllegalArgumentException("There is no data for writing");
        }
        try {
            Files.writeString(Path.of(fileName),data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file", e);
        }
    }
}
