package core.basesyntax.service;

import core.basesyntax.exceptions.InvalidOperationException;
import core.basesyntax.interfaces.DataLineValidator;
import core.basesyntax.interfaces.TransactionsFormer;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionsFormerImpl implements TransactionsFormer {
    private static final DataLineValidator validator = new DataLineLineValidatorImpl();
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMA_SEPARATOR = ",";

    public List<FruitTransaction> formTransactionList(List<String> data) {
        checkListForData(data);
        List<FruitTransaction> list = new ArrayList<>();
        for (String line : data) {
            String[] value = line.split(COMA_SEPARATOR);
            validator.dataCheck(value);
            FruitTransaction fruitTransaction = new FruitTransaction(
                    FruitTransaction.Operation.getByCode(value[OPERATION_INDEX]),
                    value[FRUIT_NAME_INDEX],
                    Integer.parseInt(value[QUANTITY_INDEX]));
            list.add(fruitTransaction);
        }
        return list;
    }

    private void checkListForData(List<String> data) {
        if (data == null || data.isEmpty()) {
            throw new InvalidOperationException("There is no operations to execute");
        }
    }
}
