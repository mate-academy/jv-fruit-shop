package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TheFileReaderImpl implements TheFileReader {
    private static final int TITLE = 0;

    @Override
    public List<String> readFromFile(String fileName) {
        List<String> reader;
        try {
            reader = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("no file Bro!", e);
        }
        reader.remove(TITLE);
        return reader;
    }
}
