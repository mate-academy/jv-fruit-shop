package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                lines.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + fileName);
        }
        lines.remove(0);
        return lines;
    }
}
