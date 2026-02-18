package core.basesyntax;

import java.util.*;

public class ShopServiceImpl implements ShopService{
    private final Map<String, Integer> storage = new HashMap<>();
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }
    @Override
    public void process(List<FruitTransaction> transactions) {

        for (FruitTransaction transaction : transactions) {
           operationStrategy.handle(transaction, storage);
        }
    }
    public Map<String, Integer> getStorage() {
        return storage;
    }
}
