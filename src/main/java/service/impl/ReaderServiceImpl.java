package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFilesContents(String inputFile) {
        try {
            return Files.lines(Path.of(inputFile)).skip(1).toList();
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file: " + inputFile, e);
        }
    }
}

