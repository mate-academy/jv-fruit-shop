package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    private String line = "";
    private List<String> fruitData = new ArrayList<>();

    @Override
    public List<String> readFromFile(String filePath) {
        try (BufferedReader readFromFile = new BufferedReader(new FileReader(filePath))) {
            while ((line = readFromFile.readLine()) != null) {
                fruitData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to reach to the file", e);
        }
        return fruitData;
    }
}
