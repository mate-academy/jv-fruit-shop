package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.strategy.TransactionsStrategy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final String PATHNAME = "src/main/resources/operations.csv";
    private static final int TYPE_OF_OPERATION_INDEX = 0;
    private static final int FRUIT_TITLE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    private TransactionsStrategy transactionsStrategy;

    public CsvFileReaderServiceImpl(TransactionsStrategy transactionsStrategy) {
        this.transactionsStrategy = transactionsStrategy;
    }

    @Override
    public List<FruitTransaction> read() {
        List<String> dataFromFile = new ArrayList<>();

        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        try {
            dataFromFile = Files.readAllLines(Path.of(PATHNAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
        Consumer<String[]> consumer = stringArray ->
                fruitTransactions.add(
                        new FruitTransaction(transactionsStrategy
                                .get(stringArray[TYPE_OF_OPERATION_INDEX]).getOperation(),
                                stringArray[FRUIT_TITLE_INDEX],
                                Integer.parseInt(stringArray[AMOUNT_INDEX])));
        dataFromFile.stream()
                .map(string -> string.split(","))
                .skip(1)
                .forEach(consumer);
        return fruitTransactions;
    }
}
