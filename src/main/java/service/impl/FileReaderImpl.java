package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FileReader;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String pathName) {
        List<String> data;
        try {
            data = Files.readAllLines(Path.of(pathName));
        } catch (IOException e) {
            throw new RuntimeException("Can't find this file " + pathName, e);
        }
        return data;
    }
}
