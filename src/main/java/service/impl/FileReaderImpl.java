package service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.FileReader;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                result.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + filePath, e);
        }
        return result;
    }
}
