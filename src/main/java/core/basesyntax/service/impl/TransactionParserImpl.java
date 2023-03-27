package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLIT_SYMBOL = ",";

    @Override
    public List<FruitTransaction> getDataFromLine(List<String> stringTransactions) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String line : stringTransactions) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] arrayParameters = line.split(SPLIT_SYMBOL);
            addParameters(fruitTransaction, arrayParameters);
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }

    private void addParameters(FruitTransaction fruitTransaction, String[] arrayParameters) {
        fruitTransaction.setOperation(fruitTransaction
                .getOperationFromValue(arrayParameters[TYPE_INDEX]));
        fruitTransaction.setFruit(new Fruit(arrayParameters[FRUIT_INDEX]));
        fruitTransaction.setQuantity(Integer.parseInt(arrayParameters[QUANTITY_INDEX]));
    }
}
