package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class DataParsedImpl implements ParserService {
    private static final String SPLITERATOR = ",";
    private static final int TITLE = 1;
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        List<String> filteredData = data.stream()
                .skip(TITLE)
                .map(String::trim)
                .toList();
        for (String line : filteredData) {
            String[] splitData = line.split(SPLITERATOR);
            fruitTransactions.add(new FruitTransaction(FruitTransaction.Operation
                    .getOperation(splitData[OPERATION]), splitData[FRUIT],
                    Integer.parseInt(splitData[QUANTITY])));
        }
        return fruitTransactions;
    }
}
