package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Can not read file " + fileName, e);
        }
    }
}
