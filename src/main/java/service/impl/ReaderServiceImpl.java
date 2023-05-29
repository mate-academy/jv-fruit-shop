package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import model.Fruit;
import service.ParserService;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String TITLE = "type";
    private ParserService parserService;

    public ReaderServiceImpl(ParserService parserService) {
        this.parserService = parserService;
    }

    @Override
    public List<Fruit> readFromFile(String fileName) {
        List<String> fruit;
        try {
            fruit = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file " + fileName);
        }
        return fruit.stream()
                .filter(line -> !line.startsWith(TITLE))
                .map(line -> parserService.getFruitFromCsvRow(line))
                .collect(Collectors.toList());
    }
}
