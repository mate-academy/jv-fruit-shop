package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransaction;
import core.basesyntax.models.Fruit;
import core.basesyntax.service.FruitTransactionParser;
import java.util.List;

public class CsvParser implements FruitTransactionParser {
    private static final String COMMA = ",";
    private static final int OPERATION_CODE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_AMOUNT = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> data) {
        return data.stream().map(this::lineToFruitTransaction).toList();
    }

    private FruitTransaction lineToFruitTransaction(String line) {
        String[] transactionData = line.split(COMMA);
        FruitTransaction.Operation operation =
                FruitTransaction.Operation.fromCode(transactionData[OPERATION_CODE]);
        Fruit fruit = new Fruit(transactionData[FRUIT_NAME]);
        int fruitAmount = Integer.parseInt(transactionData[FRUIT_AMOUNT]);
        return new FruitTransaction(operation, fruit, fruitAmount);
    }
}
