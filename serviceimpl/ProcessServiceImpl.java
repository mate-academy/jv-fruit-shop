package core.basesyntax.serviceImpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessService;
import core.basesyntax.strategy.Strategy;

import java.security.Provider;
import java.util.List;

public class ProcessServiceImpl implements ProcessService {
    private final Strategy strategy;

    public ProcessServiceImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction transaction : fruitTransactionList) {
            strategy.get(transaction.getOperation()).processOperation(transaction);
        }
    }
}
