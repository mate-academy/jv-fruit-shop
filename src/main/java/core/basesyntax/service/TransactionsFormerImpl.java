package core.basesyntax.service;

import core.basesyntax.exceptions.InvalidOperationException;
import core.basesyntax.interfaces.TransactionsFormer;
import core.basesyntax.model.FruitTransaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionsFormerImpl implements TransactionsFormer {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMA_SEPARATOR = ",";

    public List<FruitTransaction> formTransactionList(List<String> data) {
        List<FruitTransaction> list = new ArrayList<>();
        for (String line : data) {
            String[] value = line.split(COMA_SEPARATOR);
            if (value.length != 3) {
                throw new InvalidOperationException("Wrong operation input");
            }
            String fruit = value[FRUIT_NAME_INDEX];
            if (fruit == null || fruit.isEmpty()) {
                throw new InvalidOperationException("Fruit name can`t be null");
            }
            int quantity = Integer.parseInt(value[QUANTITY_INDEX]);
            if (quantity < 0) {
                throw new InvalidOperationException(
                        "Can't change quantity less than 0, line's quantity is "
                                + quantity);
            }
            FruitTransaction fruitTransaction = new FruitTransaction(
                    value[OPERATION_INDEX],
                    value[FRUIT_NAME_INDEX],
                    quantity);
            list.add(fruitTransaction);
        }
        return list;
    }
}
