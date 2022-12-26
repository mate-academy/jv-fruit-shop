package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransactions(String data) {
        String[] fromFile = data.split("\r\n");
        List<FruitTransaction> fruitList = new ArrayList<>();
        for (String line : fromFile) {
            String[] splited = line.split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction
                    .setOperation(FruitTransaction.Operation
                            .getOperationByCode(splited[OPERATION_INDEX]));
            fruitTransaction.setFruit(splited[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(splited[QUANTITY_INDEX]));
            fruitList.add(fruitTransaction);
        }
        return fruitList;
    }
}
