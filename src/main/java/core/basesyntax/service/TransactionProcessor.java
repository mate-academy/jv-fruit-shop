package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;

public class TransactionProcessor {
    private Storage storage;
    private HashMap<FruitTransaction.Operation, OperationStrategy> operationMap;

    private TransactionProcessor(Storage storage) {
        this.storage = storage;
        operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
    }

    public void processTransaction(FruitTransaction transaction) {
        operationMap.get(transaction.getOperation())
                .processTransaction(transaction,storage);
    }

    public static TransactionProcessor of(Storage storage) {
        return new TransactionProcessor(storage);
    }

}
