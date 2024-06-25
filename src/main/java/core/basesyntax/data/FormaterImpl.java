package core.basesyntax.data;

import core.basesyntax.operation.Operation;
import core.basesyntax.transaction.FruitTransaction;
import java.util.Arrays;
import java.util.List;

public class FormaterImpl implements Formater {
    private static final String DEFAULT_DELIMITER = ",";
    private static final String OPERATION = "type";
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private int operationIndex;
    private int fruitIndex;
    private int quantityIndex;

    FormaterImpl(String pattern) {
        String[] elements = pattern.split(DEFAULT_DELIMITER);
        List<String> list = Arrays.asList(elements);
        operationIndex = list.indexOf(OPERATION);
        fruitIndex = list.indexOf(FRUIT);
        quantityIndex = list.indexOf(QUANTITY);
    }

    @Override
    public FruitTransaction parseTransaction(String s) {
        String[] elements = s.split(DEFAULT_DELIMITER);
        FruitTransaction fruitTransaction = new FruitTransaction();
        Operation operation = Operation.getOperation(elements[operationIndex].strip());
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(elements[fruitIndex].strip());
        fruitTransaction.setQuantity(Integer.parseInt(elements[quantityIndex].strip()));
        return fruitTransaction;
    }
}
