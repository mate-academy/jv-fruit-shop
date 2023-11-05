package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int COLUMN_NAMES = 1;

    @Override
    public List<FruitTransaction> parse(List<String> list) {
        return list.stream()
                .skip(COLUMN_NAMES)
                .map(this::parseTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseTransaction(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] parseTransaction = line.split(",");
        String operator = parseTransaction[OPERATION_TYPE_INDEX].trim();
        fruitTransaction.setOperation(
                FruitTransaction.Operation.getByCode(operator));
        fruitTransaction.setFruit(parseTransaction[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(parseTransaction[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
