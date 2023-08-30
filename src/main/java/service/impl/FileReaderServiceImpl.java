package service.impl;

import service.FileReaderService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceImpl implements FileReaderService {
    private static final int OFFSET = 1;
    @Override
    public List<String> readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                    .skip(OFFSET)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + filePath, e);
        }
    }
}
