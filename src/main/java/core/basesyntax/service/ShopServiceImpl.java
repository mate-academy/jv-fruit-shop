package core.basesyntax.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;
    private Map<String, Integer> fruitRepository;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        fruitRepository = new HashMap<>();
    }

    @Override
    public Map<String, Integer> getFruitRepository() {
        return fruitRepository;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            operationStrategy.execute(transaction, fruitRepository);
        }
    }
}
