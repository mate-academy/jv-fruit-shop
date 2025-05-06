package service.impl;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import service.FileReader;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String filePath) {
        try (BufferedReader bufferedReader =
                     Files.newBufferedReader(Paths.get(filePath))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Can`t read file: " + filePath, e);
        }
    }
}
