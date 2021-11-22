package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String INPUT_FILE_NAME = "src\\main\\resources\\input.csv";
    private List<String> input;

    @Override
    public List<String> read() {
        try {
            input = Files.readAllLines(Path.of(INPUT_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
