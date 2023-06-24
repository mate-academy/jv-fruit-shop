package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.ArrayList;
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
            if (fileLine.isEmpty()) {
                continue;
            }
            String[] transactionInfo = fileLine.split(REGEX);
            int amount = 0;
            try {
                amount = Integer.parseInt(transactionInfo[QUANTITY_INDEX]);
            } catch (NumberFormatException e) {
                throw new RuntimeException(
                        "Invalid quantity of product from file to create transaction "
                        + transactionInfo[QUANTITY_INDEX]);
            }
            fruitTransactions.add(new FruitTransaction(
                    FruitTransaction.Operation.getByCode(transactionInfo[OPERATION_TYPE_INDEX]),
                    transactionInfo[FRUIT_NAME_INDEX].toLowerCase(),
                    amount));
        }
        return fruitTransactions;
    }
}
