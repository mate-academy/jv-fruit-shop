package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String EXCEPTION_MESSAGE_FOR_READING = "Can't read data from file ";
    private static final String EXCEPTION_MESSAGE_FOR_FILEPATH = "FilePath argument is null";
    private static final int INFORMATIVE_LINE_INDEX = 0;

    @Override
    public List<String> readFromFile(String filePath) {
        if (filePath == null) {
            throw new RuntimeException(EXCEPTION_MESSAGE_FOR_FILEPATH);
        }
        List<String> data = new ArrayList<>();
        try {
            data = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE_FOR_READING + filePath, e);
        }
        if (data.size() != 0) {
            data.remove(INFORMATIVE_LINE_INDEX);
        }
        return data;
    }
}
