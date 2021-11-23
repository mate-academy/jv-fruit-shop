package service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> operations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                operations.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Invalid file name: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Read failed", e);
        }
        return operations;
    }
}
