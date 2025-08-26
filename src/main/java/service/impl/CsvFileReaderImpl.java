package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.CsvFileReader;

public class CsvFileReaderImpl implements CsvFileReader {

    @Override
    public List<String> read(String filePath) {
        if (filePath == null) {
            throw new RuntimeException("Path to file cannot be null");
        }
        if (filePath.isEmpty()) {
            throw new RuntimeException("Path to file cannot be empty: " + filePath);
        }

        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }

        return lines;
    }
}
