package service;

import db.FruitsStorage;
import java.util.List;
import model.FruitTransaction;
import strategy.DalyOperationStrategy;

public interface FruitDalyTransactionsHandler {
    FruitsStorage getFruitBalance(List<FruitTransaction> fruitTransactions,
                                  DalyOperationStrategy strategy);
}
