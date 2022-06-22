package service;

import model.FruitTransaction;
import strategy.FruitsAmountHandler;

public interface FruitsAmountStrategy {
    FruitsAmountHandler get(FruitTransaction.Operation operation);
}
