package impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.FileReaderService;

public class FileReaderImpl implements FileReaderService {
    @Override
    public List<String> dataFromFile(String filePath) {
        List<String> inputData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                inputData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file by path: " + filePath, e);
        }
        if (inputData.isEmpty()) {
            throw new RuntimeException("File is empty");
        }
        return inputData;
    }
}
