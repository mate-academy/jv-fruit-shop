package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {
    private static final int OFFSET = 1;

    @Override
    public List<String> readFromFile(String fileRead) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileRead))) {
            return reader.lines()
                    .skip(OFFSET)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileRead, e);
        }
    }
}
