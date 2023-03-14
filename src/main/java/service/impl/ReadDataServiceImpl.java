package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import service.ReadDataService;

public class ReadDataServiceImpl implements ReadDataService {
    public static final int IGNORE_TITTLE_INDEX = 1;
    public static final String STRING_SPLITERATOR = ",";

    @Override
    public List<String[]> read(String filename) {
        try {
            return Files.readAllLines(Path.of(filename)).stream()
                    .skip(IGNORE_TITTLE_INDEX)
                    .map(string -> string.split(STRING_SPLITERATOR))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file" + filename,e);
        }
    }
}
