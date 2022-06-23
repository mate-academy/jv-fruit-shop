package service;

import model.FruitTransaction;
import strategy.FruitsAmountHandler;

public interface FruitOperationStrategy {
    FruitsAmountHandler get(FruitTransaction.Operation operation);
}
