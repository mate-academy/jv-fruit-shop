package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FileService;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> readFromFile(String fileName) {
        List<String> fruitOperations;
        try {
            fruitOperations = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fileName);
        }
        return fruitOperations;
    }

    @Override
    public boolean writeToFile(String data, String fileName) {
        if (data == null) {
            return false;
        }
        try {
            Files.writeString(Path.of(fileName), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to " + fileName, e);
        }
        return true;
    }
}
