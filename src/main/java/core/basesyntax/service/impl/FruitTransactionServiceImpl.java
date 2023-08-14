package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final FruitTransaction.Operation
            TOTAL = FruitTransaction.Operation.TOTAL;
    private final OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void calculate() {
        Map<String, List<FruitTransaction>> transactionMap = Storage.fruitTransactions.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit,
                        Collectors.mapping(fruitTransaction -> fruitTransaction,
                                Collectors.toList())));
        for (Map.Entry<String, List<FruitTransaction>> entry : transactionMap.entrySet()) {
            int result = 0;
            List<FruitTransaction> fruitTransactions = entry.getValue();
            for (FruitTransaction fruitTransaction : fruitTransactions) {
                result = operationStrategy.get(fruitTransaction.getOperation())
                        .getOperation(result, fruitTransaction.getQuantity());
            }
            if (result < 0) throw new RuntimeException("Balance mustn't be negative");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(TOTAL);
            fruitTransaction.setFruit(entry.getKey());
            fruitTransaction.setQuantity(result);
            Storage.fruitTransactions.add(fruitTransaction);
        }
    }
}
