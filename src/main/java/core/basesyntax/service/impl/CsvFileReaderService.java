package core.basesyntax.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import core.basesyntax.service.FileReaderService;

public class CsvFileReaderService implements FileReaderService {
    @Override
    public List<String> read(File file) {
        List<String> list;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            list = bufferedReader.lines()
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + file + " does not exist.", e);
        } catch (IOException e) {
            throw new RuntimeException("Stream already closet", e);
        }
        return list;
    }
}
