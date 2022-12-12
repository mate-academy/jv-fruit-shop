package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class ReaderServiceImpl implements ReaderService {
    private static final int INFORM_LINE = 1;
    private FruitTransactionService fruitTransactionService;

    public ReaderServiceImpl(FruitTransactionService fruitTransactionService) {
        this.fruitTransactionService = fruitTransactionService;
    }

    @Override
    public List<FruitTransaction> read(Path path) {
        try {
            return Files.readAllLines(path).stream()
                    .skip(INFORM_LINE)
                    .map(fruitTransactionService::createNewTransaction)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file", e);
        }
    }
}
