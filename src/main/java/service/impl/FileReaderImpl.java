package service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements service.FileReader {

    @Override
    public List<String> read(String filePath) {
        List<String> output = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String value;
            while ((value = reader.readLine()) != null) {
                output.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while reading file: " + filePath, e);
        }
        return output;
    }
}
