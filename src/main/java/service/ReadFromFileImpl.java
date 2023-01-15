package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> listOfValues;
        try {
            listOfValues = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + filePath);
        }
        return listOfValues;
    }
}
