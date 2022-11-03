package implementation;

import java.util.List;
import model.FruitTransaction;
import service.FruitService;
import strategy.Strategy;

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
