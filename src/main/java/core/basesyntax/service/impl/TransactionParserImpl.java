package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final String DATA_SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> fruitDataFromFile) {
        return fruitDataFromFile.stream()
                .map(this::convertLineToFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction convertLineToFruitTransaction(String line) {
        String[] lineParts = line.split(DATA_SPLITTER);
        FruitTransaction fruitTransaction = new FruitTransaction();
        try {
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getOperation(lineParts[OPERATION_INDEX]));
            fruitTransaction.setFruit(lineParts[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(lineParts[QUANTITY_INDEX]));
            return fruitTransaction;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
