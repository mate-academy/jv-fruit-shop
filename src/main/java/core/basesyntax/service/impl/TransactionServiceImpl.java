package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String REGEX = ",";

    @Override
    public List<FruitTransaction> createTransactions(List<String> fileLines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String fileLine : fileLines) {
            String[] transactionInfo = fileLine.split(REGEX);
            String operationType = transactionInfo[OPERATION_TYPE_INDEX];
            String fruitName = transactionInfo[FRUIT_NAME_INDEX].toLowerCase();
            int amount = Integer.parseInt(transactionInfo[QUANTITY_INDEX]);

            FruitTransaction.Operation operation =
                    Arrays.stream(FruitTransaction.Operation.values())
                        .filter(o -> o.getCode().equalsIgnoreCase(operationType))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Wrong type of operation "
                            + transactionInfo[OPERATION_TYPE_INDEX]));

            FruitTransaction fruitTransaction = new FruitTransaction(
                    operation,
                    fruitName,
                    amount);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
