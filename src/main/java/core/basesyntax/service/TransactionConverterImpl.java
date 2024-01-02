package core.basesyntax.service;

import core.basesyntax.Operation;
import java.util.ArrayList;
import java.util.List;

public class TransactionConverterImpl implements TransactionConverter {
    final int OPERATION_NUMBER = 0;
    final int TRANSACTION_NUMBER = 1;
    final int QUNTITY_FRUIT = 2;
    @Override
    public List<FruitTransaction> convert(List<String> stringList) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String record : stringList) {
            String[] line = record.split(",");
            Operation operation = Operation.getOperationFromCode(line[OPERATION_NUMBER]);
            FruitTransaction transaction = new FruitTransaction(operation, line[TRANSACTION_NUMBER],
                    Integer.parseInt(line[QUNTITY_FRUIT]));
            fruitTransactionList.add(transaction);
        }
        return fruitTransactionList;
    }
}
