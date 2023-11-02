package service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<String> read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line = reader.readLine();
            List<String> rows = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                rows.add(line);
            }

            return rows;
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file");
        }
    }
}
