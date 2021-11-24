package service.implement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FileReader;

public class FileReaderImpl implements FileReader {
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
