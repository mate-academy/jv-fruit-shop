package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.Arrays;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_DATA = 0;
    private static final int FRUIT_NAME_DATA = 1;
    private static final int QUANTITY_DATA = 2;
    private static final String SPLITERATOR = ",";

    @Override
    public FruitTransaction parse(String lineFromFile) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] transactionData = lineFromFile.split(SPLITERATOR);
        fruitTransaction.setOperation(Arrays.stream(FruitTransaction.OperationType.values())
                .filter(type -> type.getOperationType().equals(transactionData[OPERATION_DATA]))
                .findFirst()
                .get());
        fruitTransaction.setFruitName(transactionData[FRUIT_NAME_DATA]);
        fruitTransaction.setQuantity(Integer.parseInt(transactionData[QUANTITY_DATA]));
        return fruitTransaction;
    }
}
