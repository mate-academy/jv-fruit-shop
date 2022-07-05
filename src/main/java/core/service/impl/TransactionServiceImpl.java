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
    public FruitTransaction createFromString(String stringTransaction) {
        String[] fields = stringTransaction.split(",");
        int quantity;
        try {
            quantity = Integer.parseInt(fields[QUANTITY_POS]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Value " + fields[QUANTITY_POS] + " isn`t integer", e);
        }
        return FruitTransaction
                .build(fields[OPERATION_POS], fields[FRUIT_POS], quantity);
    }

    @Override
    public List<FruitTransaction> createFromList(List<String> transactions) {
        return transactions.stream()
                .map(this::createFromString)
                .collect(Collectors.toList());
    }
}
