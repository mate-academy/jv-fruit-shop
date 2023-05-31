package service.impl;

import java.util.List;
import models.FruitTransaction;
import service.FruitService;
import service.operation.OperationHandler;
import strategy.Strategy;

public class FruitServiceImpl implements FruitService {
    private final Strategy strategy;

    public FruitServiceImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruit: fruitTransactions) {
            OperationHandler handler = strategy.get(fruit.getOperation());
            handler.handle(fruit);
        }
    }
}
