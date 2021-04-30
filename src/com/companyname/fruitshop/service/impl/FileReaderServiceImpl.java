package com.companyname.fruitshop.service.impl;

import com.companyname.fruitshop.service.interfaces.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private final Path filePath;

    public FileReaderServiceImpl(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readLines() {
        return readLinesFromFile(filePath);
    }

    private List<String> readLinesFromFile(Path filePath) {
        List<String> lines;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath);
        }
        return lines;
    }
}
