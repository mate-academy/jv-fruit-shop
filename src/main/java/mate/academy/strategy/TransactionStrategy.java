package mate.academy.strategy;

import mate.academy.model.FruitTransaction;
import mate.academy.service.transaction.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
