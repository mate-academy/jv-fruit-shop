package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String FILE_PATH = "src/main/resources/data.csv";

    @Override
    public String[] readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            return reader.lines().skip(1)
                    .map(line -> line.split(System.lineSeparator()))
                    .flatMap(Arrays::stream)
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file");
        }
    }
}
