package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReadFromFile;

public class ReadFromCsvFileImpl implements ReadFromFile {
    @Override
    public List<String> readFromCsvFile(String fromFilePath) {
        try {
            return Files.readAllLines(Path.of(fromFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from your amazing file "
                    + fromFilePath + " !", e);
        }
    }
}
