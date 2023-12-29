package core.basesyntax.service;

import core.basesyntax.Operation;
import java.util.ArrayList;

public class ConvertDataImpl implements ConvertData {
    final int OPERATION_NUMBER = 0;
    final int TRANSACTION_NUMBER = 1;
    final int QUNTITY_FRUIT = 2;
    @Override
    public ArrayList<FruitTransaction> convert(String data) {
        ArrayList<FruitTransaction> fruitTransactionList = new ArrayList<>();
        String[] lines = data.split("\\n");
        for (String record : lines) {
            String[] line = record.split(",");
            Operation operation = Operation.getOperationFromCode(line[OPERATION_NUMBER]);
            FruitTransaction transaction = new FruitTransaction(operation, line[TRANSACTION_NUMBER],
                    Integer.parseInt(line[QUNTITY_FRUIT]));
            fruitTransactionList.add(transaction);
        }
        return fruitTransactionList;
    }
}
