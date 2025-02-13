package service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import service.FileReader;

public class FileReaderImpl implements FileReader {
    public FileReaderImpl() {
    }

    @Override
    public List<String> read(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            return lines.subList(1, lines.size());
        }
        catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
    }
}
