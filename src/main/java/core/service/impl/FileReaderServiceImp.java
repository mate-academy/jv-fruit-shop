package core.service.impl;

import core.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceImp implements FileReaderService {
    private static final int OFFSET = 1;

    @Override
    public List<String> read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().skip(OFFSET).collect(Collectors.toList());
        } catch (IOException exception) {
            throw new RuntimeException("Can't read the file " + filePath);
        }
    }
}
