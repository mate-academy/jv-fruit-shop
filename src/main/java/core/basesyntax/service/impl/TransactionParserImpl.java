package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> transactionList = new ArrayList<>();

        for (String transaction : data) {
            String operation = transaction.split(",")[OPERATION_INDEX];
            String fruit = transaction.split(",")[FRUIT_INDEX];
            String quantity = transaction.split(",")[QUANTITY_INDEX];

            FruitTransaction.Operation parsedOperation = null;
            Fruit parsedFruit = new Fruit(fruit);
            int parsedQuantity = Integer.parseInt(quantity);

            for (FruitTransaction.Operation o : FruitTransaction.Operation.values()) {
                if (o.getCode().equals(operation)) {
                    parsedOperation = o;
                    break;
                }
            }

            if (parsedOperation == null) {
                throw new RuntimeException("Unsupported operation type: " + operation);
            } else {
                transactionList.add(
                        new FruitTransaction(parsedOperation, parsedFruit, parsedQuantity));
            }
        }

        return transactionList;
    }
}
