package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getTransactionFromString(List<String> fruitTransactions) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        for (String string : fruitTransactions) {
            FruitTransaction transaction = new FruitTransaction();
            String[] data = string.split(",");
            transaction.setFruit(data[FRUIT_NAME_INDEX]);
            transaction.setOperation((FruitTransaction.Operation.valueOf(FruitTransaction.Operation
                    .getOperationByString(data[OPERATION_INDEX]))));
            transaction.setQuantity(Integer.parseInt(data[QUANTITY_INDEX]));
            fruitTransactionsList.add(transaction);
        }
        return fruitTransactionsList;
    }
}
