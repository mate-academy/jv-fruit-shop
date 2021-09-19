package service.impl;

import service.FileReaderService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFile(String fileName) {
        List<String> dataInput = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                dataInput.add(value);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
        return dataInput;
    }
}
