package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransaction(List<String> fromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] transactionParts;
        for (int i = 1; i < fromFile.size(); i++) {
            transactionParts = fromFile.get(i).split(SEPARATOR);
            fruitTransactions.add(new FruitTransaction(
                    FruitTransaction.Operation.getOperation(transactionParts[OPERATION_INDEX]),
                    new Fruit(transactionParts[FRUIT_NAME_INDEX]),
                    Integer.parseInt(transactionParts[QUANTITY_INDEX])));
        }
        return fruitTransactions;
    }
}
