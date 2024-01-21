package core.basesyntax.transaction;

import core.basesyntax.Operation;
import java.util.ArrayList;
import java.util.List;

public class TransactionConverterImpl implements TransactionConverter {
    final int OPERATION_NUMBER = 0;
    final int TRANSACTION_NUMBER = 1;
    final int QUNTITY_FRUIT = 2;
    final String SERARATOP = ",";
    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String record : lines) {
            String[] line = record.split(SERARATOP);
            Operation operation = Operation.getOperationFromCode(line[OPERATION_NUMBER]);
            FruitTransaction transaction = new FruitTransaction(operation, line[TRANSACTION_NUMBER],
                    Integer.parseInt(line[QUNTITY_FRUIT]));
            fruitTransactionList.add(transaction);
        }
        return fruitTransactionList;
    }
}
