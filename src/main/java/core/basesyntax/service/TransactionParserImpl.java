package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY = 2;

    public List<FruitTransaction> parseFruitTransactions(List<String> lines) {
        List<FruitTransaction> dataList = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] array = lines.get(i).split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation.getByCode(
                    array[OPERATION_INDEX]));
            fruitTransaction.setFruit(array[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(array[QUANTITY]));
            dataList.add(fruitTransaction);
        }
        return dataList;
    }
}

