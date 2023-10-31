package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String EXCEPTION_MESSAGE_FOR_FILEPATH = "FilePath argument is null";
    private static final String EXCEPTION_MESSAGE_FOR_READING = "Can't read data from file: ";
    private static final String EXCEPTION_MESSAGE_FOR_FILE_CONTENT = "Input file is empty: ";

    @Override
    public List<String> readFromFile(String filePath) {
        String sourceFile = Optional.ofNullable(filePath)
                .orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE_FOR_FILEPATH));
        List<String> data = new ArrayList<>();
        try {
            data = Files.readAllLines(Path.of(sourceFile));
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE_FOR_READING + filePath);
        }
        if (data.isEmpty()) {
            throw new RuntimeException(EXCEPTION_MESSAGE_FOR_FILE_CONTENT + filePath);
        }
        return data;
    }
}
