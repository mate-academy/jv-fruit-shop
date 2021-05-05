package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import service.FileService;

public class FileServiceImpl implements FileService {
    private static final String ERROR_READ_MESSAGE = "Can`t read from file ";
    private static final String ERROR_WRITE_MESSAGE = "Can`t write to file ";

    @Override
    public List<String> readFromCsvFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(ERROR_READ_MESSAGE + filePath, e);
        }
    }

    @Override
    public void writeToCsvFile(String filePath, String reportData) {
        try {
            Files.write(Path.of(filePath), reportData.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(ERROR_WRITE_MESSAGE + filePath, e);
        }
    }
}
