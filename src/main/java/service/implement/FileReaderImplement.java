package service.implement;

import service.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImplement implements FileReader {
    private List<String> input;

    @Override
    public List<String> read(String fileName) {
        try {
            input = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("file not read");
        }
        return input;
    }
}
