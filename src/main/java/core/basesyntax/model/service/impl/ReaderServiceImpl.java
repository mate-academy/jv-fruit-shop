package core.basesyntax.model.service.impl;

import core.basesyntax.model.exception.InvalidDataException;
import core.basesyntax.model.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                    .skip(1)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new InvalidDataException("Incorrect file path: " + filePath);
        }
    }
}
