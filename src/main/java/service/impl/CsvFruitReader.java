package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.Reader;

public class CsvFruitReader implements Reader {
    private static final String PATH_FOR_READ = "src/main/resources/Fruits.csv";

    @Override
    public List<String> read() {
        List<String> result;
        try {
            Path pathOfFile = Path.of(PATH_FOR_READ);
            result = Files.readAllLines(pathOfFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from " + PATH_FOR_READ + "  " + e);
        }
        return result;
    }
}
