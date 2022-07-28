package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserImpl implements DataParser {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseFruitTransactions(List<String[]> info) {
        return info.stream()
                .map(this::makeFruitTransaction)
                .collect(Collectors.toList());
    }

    public FruitTransaction makeFruitTransaction(String[] strings) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getOperationType(strings[OPERATION_TYPE_INDEX]));
        fruitTransaction.setFruitType(strings[FRUIT_TYPE_INDEX]);
        fruitTransaction.setFruitQuantity(Integer.parseInt(strings[FRUIT_QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
