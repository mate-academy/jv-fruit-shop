package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.DataParserService;
import core.basesyntax.strategy.TransactionsStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DataParserServiceImpl implements DataParserService {
    private CsvFileReaderService fileReaderService;
    private TransactionsStrategy transactionsStrategy;
    private static final int TYPE_OF_OPERATION_INDEX = 0;
    private static final int FRUIT_TITLE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    public DataParserServiceImpl(CsvFileReaderService fileReaderService,
                                 TransactionsStrategy transactionsStrategy) {
        this.fileReaderService = fileReaderService;
        this.transactionsStrategy = transactionsStrategy;
    }

    @Override
    public List<FruitTransaction> parse() {
        List<String> dataFromFile = fileReaderService.read();
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        Consumer<String[]> parseConsumer = stringArray ->
                fruitTransactions.add(
                        new FruitTransaction(transactionsStrategy
                                .get(stringArray[TYPE_OF_OPERATION_INDEX]),
                                stringArray[FRUIT_TITLE_INDEX],
                                Integer.parseInt(stringArray[AMOUNT_INDEX])));
        dataFromFile.stream()
                .map(string -> string.split(","))
                .skip(1)
                .forEach(parseConsumer);
        return fruitTransactions;
    }
}
