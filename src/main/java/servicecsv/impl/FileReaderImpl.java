package servicecsv.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import servicecsv.FileReaderService;

public class FileReaderImpl implements FileReaderService {
    @Override
    public List<String[]> readTheFruitsStorage(String pathName) {
        List<String> storageData;
        try {
            storageData = Files.readAllLines(Path.of(pathName));
        } catch (IOException e) {
            throw new RuntimeException("Can't extract data from file correctly " + pathName);
        }
        List<String[]> upgrade = new ArrayList<>();
        storageData.remove(0);
        for (String string : storageData.toArray(new String[storageData.size()])) {
            upgrade.add(string.split(","));
        }
        return upgrade;
    }
}
