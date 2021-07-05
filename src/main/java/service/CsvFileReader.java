package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileReader implements FileReader {
    @Override
    public List<String> read(String filename) {
        List<String> linesFromFile;
        try {
            linesFromFile = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filename, e);
        }
        return linesFromFile;
    }
}
