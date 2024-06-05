package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int QUANTITY = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> parse(List<String> registers) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (var register : registers) {
            String[] data = register.split(SPLITTER);
            Operation operation = Operation.operationCode(data[OPERATION_INDEX]);
            String fruit = data[PRODUCT_INDEX];
            int quantity = Integer.parseInt(data[QUANTITY]);
            fruitTransactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return fruitTransactions;
    }
}
