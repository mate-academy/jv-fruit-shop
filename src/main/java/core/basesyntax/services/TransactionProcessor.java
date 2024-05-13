package core.basesyntax.services;

import static core.basesyntax.transactions.FruitsTransaction.Operation;
import static core.basesyntax.transactions.FruitsTransaction.Operation.BALANCE;
import static core.basesyntax.transactions.FruitsTransaction.Operation.PURCHASE;
import static core.basesyntax.transactions.FruitsTransaction.Operation.RETURN;
import static core.basesyntax.transactions.FruitsTransaction.Operation.SUPPLY;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.transactions.FruitsTransaction;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class TransactionProcessor implements TransactionService {
    private final FruitsDao fruitsDao;
    private Map<Operation, BiConsumer<String, Integer>> operationsMap;

    public TransactionProcessor(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
        initializeOperations();
    }

    private void initializeOperations() {
        operationsMap = Map.of(
                BALANCE, fruitsDao::balance,
                SUPPLY, fruitsDao::supply,
                PURCHASE, fruitsDao::purchase,
                RETURN, fruitsDao::returnFruits
        );
    }

    @Override
    public void processTransactions(List<FruitsTransaction> transactions) {
        transactions.forEach(transaction -> {
            BiConsumer<String, Integer> operation = this.operationsMap
                    .get(transaction.getOperation());
            if (operation == null) {
                throw new IllegalArgumentException("Unknown operation: "
                        + transaction.getOperation());
            }
            operation.accept(transaction.getFruit(), transaction.getQuantity());
        });
    }
}
