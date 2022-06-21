package serviceCSV.impl;

import serviceCSV.FileReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReaderService {
    @Override
    public List<String> readTheFruitsStorage(String pathName) {
        List<String> storageData;
        try {
            storageData = Files.readAllLines(Path.of(pathName));
        } catch (IOException e) {
            throw new RuntimeException("Can't extract data from file correctly " + pathName);
        }
        return storageData;
    }
}
