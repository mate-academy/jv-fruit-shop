package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class FileReaderImpl implements ReaderService {
    public List<String> readFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("Can't find file by path: " + filePath);
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))) {
            List<String> text = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                text.add(line);
            }
            return text;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath, e);
        }
    }
}
