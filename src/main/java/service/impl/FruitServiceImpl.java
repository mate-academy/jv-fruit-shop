package service.ipml;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.FruitService;
import strategy.FruitOperationStrategy;

public class FruitServiceImpl implements FruitService {
    private final Map<Operation, FruitOperationStrategy> strategyMap;

    public FruitServiceImpl(Map<Operation, FruitOperationStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        FruitOperationStrategy strategy;
        for (FruitTransaction transaction : transactions) {
            strategy = strategyMap.get(transaction.getOperation());
            strategy.apply(transaction);
        }
    }
}
