package core.basesyntax.service.impl;

import static core.basesyntax.model.FruitTransaction.Operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    @Override
    public List<FruitTransaction> getFruitTransactions(List<String> transactions) {
        return transactions.stream()
                .dropWhile(row -> !row.contains("type,fruit,quantity"))
                .skip(1)
                .filter(row -> !row.isBlank())
                .map(this::createNewFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction createNewFruitTransaction(String line) {
        String[] transactionFields = line.trim().split(",");
        if (transactionFields.length < 3) {
            throw new IllegalArgumentException("Fruit quantity cannot be empty");
        }
        if (transactionFields[0].isBlank()) {
            throw new IllegalArgumentException("Fruit operation type cannot be empty");
        }
        if (transactionFields[1].isBlank()) {
            throw new IllegalArgumentException("Fruit name cannot be empty");
        }
        return new FruitTransaction(
                Operation.getOperationByLetter(transactionFields[0]),
                new Fruit(transactionFields[1], Integer.parseInt(transactionFields[2])));
    }
}
