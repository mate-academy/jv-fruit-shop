package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> read(String inputFile) {
        List<String> input;
        try {
            input = Files.readAllLines(Path.of(inputFile));
        } catch (IOException e) {
            throw new RuntimeException("can`t read in file");
        }
        return input;
    }
}
