package core.basesyntax.service.file.impl;

import core.basesyntax.service.file.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class ReaderCsv implements ReaderService {
    @Override
    public String[] readFile(String filePath) {
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines()
                    .skip(1)
                    .collect(Collectors.joining(" ")).split(" ");
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + filePath, e);
        }
    }
}
