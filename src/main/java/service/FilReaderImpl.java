package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.interfaces.FileReaderService;

public class FilReaderImpl implements FileReaderService {

    @Override
    public List<String> readFromFile(String fileName) {
        List<String> fileContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                fileContent.add(line);
                line = reader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException("File not exist!", exception);
        }
        return fileContent;
    }
}
