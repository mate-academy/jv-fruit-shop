package core.service.impl;

import core.db.FruitTransaction;
import core.service.TransactionService;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService {
    private static final int OPERATION_POS = 0;
    private static final int FRUIT_POS = 1;
    private static final int QUANTITY_POS = 2;

    @Override
    public List<FruitTransaction> createFromList(List<String> transactions) {
        transactions.remove(0);
        return transactions.stream()
                .map(this::createFromString)
                .collect(Collectors.toList());
    }

    @Override
    public FruitTransaction createFromString(String stringTransaction) {
        String[] fields = stringTransaction.split(",");
        FruitTransaction.Operation operation = FruitTransaction.Operation
                .getOperationFromString(fields[OPERATION_POS]);
        int quantity = Integer.parseInt(fields[QUANTITY_POS]);
        return new FruitTransaction(operation, fields[FRUIT_POS], quantity);
    }
}
