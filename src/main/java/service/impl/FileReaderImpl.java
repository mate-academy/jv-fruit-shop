package service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import service.FileReader;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't properly read file from path: " + filePath, e);
        }
        return lines;
    }
}



