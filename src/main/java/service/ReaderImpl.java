package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    private String line = "";

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> fruitData = new ArrayList<>();
        try (BufferedReader readFromFile = new BufferedReader(new FileReader(filePath))) {
            while ((line = readFromFile.readLine()) != null) {
                fruitData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file", e);
        }
        return fruitData;
    }
}
