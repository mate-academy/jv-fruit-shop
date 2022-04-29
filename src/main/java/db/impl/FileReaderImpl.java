package db.impl;

import db.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String pathName) {
        List<String> readFromFile;
        try {
            readFromFile = Files.readAllLines(Path.of(pathName));
        } catch (IOException e) {
            throw new RuntimeException("Can't find this file " + pathName, e);
        }
        return readFromFile;
    }
}
