package core.basesyntax.transaction;

import core.basesyntax.Operation;
import java.util.ArrayList;
import java.util.List;

public class TransactionConverterImpl implements TransactionConverter {
    final int OPERATION_INDEX = 0;
    final int FRUIT_INDEX = 1;
    final int QUNTITY_INDEX = 2;
    final String COMMA_SEPARATOP = ",";
    final int FIRST_TRANSACTION_LINE_INDEX = 1;

    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = FIRST_TRANSACTION_LINE_INDEX; i < lines.size(); i++) {
            String[] line = lines.get(i).split(COMMA_SEPARATOP);
            Operation operation = Operation.getOperationFromCode(line[OPERATION_INDEX]);
            FruitTransaction transaction = new FruitTransaction(operation, line[FRUIT_INDEX],
                    Integer.parseInt(line[QUNTITY_INDEX]));
            fruitTransactionList.add(transaction);
        }
        return fruitTransactionList;
    }
}
