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
    public List<FruitTransaction> convertToFruitTransaction(List<String> readFruitTransaction) {
        return readFruitTransaction.stream()
                .map(this::getFruitTransactionFromFile)
                .toList();
    }

    private FruitTransaction getFruitTransactionFromFile(String infoFromFile) {
        String[] fruitFields = infoFromFile.split(SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(
                Operation.getOperationFromCode(fruitFields[OPERATION_INDEX].trim()));
        fruitTransaction.setFruit(fruitFields[FRUIT_INDEX].trim());
        fruitTransaction.setQuantity(Integer.parseInt(fruitFields[QUANTITY_INDEX].trim()));
        return fruitTransaction;
    }
}
