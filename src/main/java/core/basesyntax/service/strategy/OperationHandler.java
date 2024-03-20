package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.repository.StorageRepository;
import core.basesyntax.service.strategy.impl.BalanceOperation;
import core.basesyntax.service.strategy.impl.PurchaseOperation;
import core.basesyntax.service.strategy.impl.ReturnOperation;
import core.basesyntax.service.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationHandler {
    private static final String WRONG_OPERATION_MESSAGE = "Wrong operation for this store ";
    private final Map<Operation, OperationStrategy> strategies;
    private final StorageRepository repository;

    public OperationHandler(StorageRepository repository) {
        this.repository = repository;
        this.strategies = new HashMap<>();
        initializeStrategies();
    }

    public void executeStrategy(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            Operation operation = transaction.getOperation();
            OperationStrategy strategy = strategies.get(operation);
            if (strategy != null) {
                strategy.execute(transaction);
            } else {
                throw new UnsupportedOperationException(WRONG_OPERATION_MESSAGE + operation);
            }
        }
    }

    private void initializeStrategies() {
        strategies.put(Operation.BALANCE, new BalanceOperation(repository));
        strategies.put(Operation.SUPPLY, new SupplyOperation(repository));
        strategies.put(Operation.PURCHASE, new PurchaseOperation(repository));
        strategies.put(Operation.RETURN, new ReturnOperation(repository));
    }
}
