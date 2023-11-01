package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String REGEX = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseListToTransactionList(List<String> fileData) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String line : fileData) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] data = line.split(REGEX);
            fruitTransaction.setOperation(Operation.getOperationByString(data[OPERATION]));
            fruitTransaction.setFruit(data[FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(data[QUANTITY]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
