package service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import service.FileReader;

public class FileReaderImpl implements FileReader {

    public FileReaderImpl() {

    }

    @Override
    public List<String> read(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + fileName, e);
        }
    }
}
