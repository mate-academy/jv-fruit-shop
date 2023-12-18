package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    private static final String SPLITERATOR = ",";
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final int TITLE = 1;

    @Override
    public List<FruitTransaction> parseRawData(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        List<String> preparedLines = lines.stream()
                .skip(TITLE)
                .map(String::trim)
                .toList();
        for (String line : preparedLines) {
            String[] splitData = line.split(SPLITERATOR);
            fruitTransactions.add(new FruitTransaction(FruitTransaction.Operation
                    .getOperation(splitData[TYPE]), splitData[FRUIT],
                    Integer.parseInt(splitData[QUANTITY])));
        }
        return fruitTransactions;
    }
}
