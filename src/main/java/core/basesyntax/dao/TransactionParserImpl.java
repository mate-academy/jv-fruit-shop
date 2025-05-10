package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> stringList) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String transaction : stringList) {
            String[] transactionDetails = transaction.split(",");

            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromCode(transactionDetails[OPERATION]);
            String fruitName = transactionDetails[FRUIT_NAME];
            int quantity = Integer.parseInt(transactionDetails[QUANTITY]);

            FruitTransaction fruitTransaction =
                    new FruitTransaction(operation, fruitName, quantity);
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
