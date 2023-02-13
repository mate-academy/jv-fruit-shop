package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvFileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> getDataFromFile(File inputFile) {
        try {
            return Files.readAllLines(inputFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can’t read file", e);
        }
    }
}
