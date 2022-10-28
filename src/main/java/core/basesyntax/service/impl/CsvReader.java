package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader implements ReaderService {
    private int linesAmountToSkip;

    @Override
    public List<String> readFile(String filePath) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(filePath))) {
            return bufferedReader.lines()
                    .skip(linesAmountToSkip)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + filePath, e);
        }
    }

    public List<String> readFile(String filePath, int linesAmountToSkip) {
        this.linesAmountToSkip = linesAmountToSkip;
        return readFile(filePath);
    }

    public void setLinesAmountToSkip(int linesAmountToSkip) {
        this.linesAmountToSkip = linesAmountToSkip;
    }
}
