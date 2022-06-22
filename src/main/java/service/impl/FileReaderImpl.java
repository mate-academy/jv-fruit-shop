package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import service.FileReaderService;

public class FileReaderImpl implements FileReaderService {
    @Override
    public List<String[]> readTheFruitsStorage(String pathName) {
        List<String> storageData;
        try {
            storageData = Files.readAllLines(Path.of(pathName));
            storageData.remove(0);
            List<String[]> upgrade = new ArrayList<>();
            for (String string : storageData.toArray(new String[0])) {
                upgrade.add(string.split(","));
            }
            return upgrade;
        } catch (IOException e) {
            throw new RuntimeException("Can't extract data from file correctly " + pathName);
        }
    }
}
