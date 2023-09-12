package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        File fromFile = new File(filePath);
        List<String> data = new ArrayList<>();
        try (BufferedReader fromFileReader = new BufferedReader(new FileReader(fromFile))) {
            data.add(fromFileReader.readLine());
            while (fromFileReader.ready()) {
                data.add(fromFileReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
        return data;
    }
}
