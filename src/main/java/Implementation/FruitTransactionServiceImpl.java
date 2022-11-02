package Implementation;

import Service.FruitService;
import Strategy.Strategy;
import core.basesyntax.FruitTransaction;

import java.util.List;

public class FruitTransactionServiceImpl implements FruitService {
    private final Strategy operationStrategy;

    public FruitTransactionServiceImpl(Strategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(f -> operationStrategy.get(f.getOperation()).handle(f));
    }
}
