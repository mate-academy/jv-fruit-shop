package strategy;

import model.FruitTransaction;

public interface TransactionService {
    void applyTransaction(FruitTransaction transaction);
}
