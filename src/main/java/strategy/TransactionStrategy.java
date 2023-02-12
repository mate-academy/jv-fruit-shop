package strategy;

import model.FruitTransaction;

public interface TransactionStrategy {
    GeneralOperation get(FruitTransaction.Operation operation);
}
