package service.impl;

import java.util.List;
import models.FruitTransaction;
import service.Processor;
import service.operation.OperationHandler;
import strategy.Strategy;

public class ProcessorImpl implements Processor {
    private final Strategy strategy;

    public ProcessorImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruit: fruitTransactionList) {
            OperationHandler handler = strategy.get(fruit.getOperation());
            handler.handle(fruit);
        }
    }
}
