package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import model.FruitTransaction;
import service.ParseService;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String ERROR = "Error reading file: ";
    private final ParseService parseService;

    public ReaderServiceImpl(ParseService parseService) {
        this.parseService = parseService;
    }

    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        try {
            return Files.lines(Paths.get(filePath))
                .skip(1)
                .map(parseService::parseLine)
                .toList();
        } catch (IOException e) {
            throw new RuntimeException(ERROR + filePath, e);
        }
    }
}
