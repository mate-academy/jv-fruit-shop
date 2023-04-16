package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReadFromFileService;

public class ReadFromFileServiceImpl implements ReadFromFileService {

    @Override
    public List<String> readCsv(String path) {
        List<String> accounts;
        try {
            accounts = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from File" + path);
        }
        return accounts;
    }
}
