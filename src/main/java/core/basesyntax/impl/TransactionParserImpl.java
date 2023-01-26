package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    public static final int OPERATION_TYPE_INDEX = 0;
    public static final int FRUIT_TYPE = 1;
    public static final int FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            FruitTransaction transaction = new FruitTransaction();
            String[] splittedLine = lines.get(i).split(",");
            FruitTransaction.Operation operation
                        = transaction.getOperationByCode(splittedLine[OPERATION_TYPE_INDEX]);
            transaction.setOperation(operation);
            transaction.setFruit(splittedLine[FRUIT_TYPE]);
            transaction.setQuantity(Integer.parseInt(splittedLine[FRUIT_QUANTITY]));
            transactions.add(transaction);
        }
        return transactions;
    }
}
