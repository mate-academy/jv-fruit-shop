package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ConverterFruitTransaction;
import java.util.List;

public class ConverterFruitTransactionImpl implements ConverterFruitTransaction {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> converterFruitTransaction(List<String> readFruitTransaction) {
        return readFruitTransaction.stream()
                .map(this::getTransaction)
                .toList();
    }

    private FruitTransaction getTransaction(String fromFile) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] fruitTransactionArray = fromFile.split(SEPARATOR);
        fruitTransaction.setOperation(Operation
                .fromCode(fruitTransactionArray[OPERATION_INDEX].trim()));
        fruitTransaction.setFruit(fruitTransactionArray[FRUIT_INDEX].trim());
        fruitTransaction.setQuantity(Integer
                .parseInt(fruitTransactionArray[QUANTITY_INDEX].trim()));

        return fruitTransaction;
    }
}
