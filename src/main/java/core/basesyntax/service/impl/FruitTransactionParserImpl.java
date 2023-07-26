package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private List<FruitTransaction> transactions = new ArrayList<>();
    private FruitTransaction fruitTransaction = new FruitTransaction();

    @Override
    public List<FruitTransaction> getFruitTransactionsList(List<String> dataAll) {
        for (int i = 0; i < dataAll.size(); i++) {
            String[] data = dataAll.get(i).split(SEPARATOR);
            if (data[OPERATION_INDEX].equals("type")) {
                continue;
            }
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .getOperation(data[OPERATION_INDEX].trim());
            String fruit = data[FRUIT_INDEX];
            try {
                int quantity = Integer.parseInt(data[QUANTITY_INDEX]);
                transactions.add(new FruitTransaction(operation, fruit, quantity));
            } catch (RuntimeException ex) {
                System.err.println("Error parsing");
            }
        }
        return transactions;
    }
}
