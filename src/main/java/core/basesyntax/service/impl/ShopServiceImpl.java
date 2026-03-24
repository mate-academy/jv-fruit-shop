package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final core.basesyntax.strategy.OperationStrategy strategy;

    public ShopServiceImpl(core.basesyntax.strategy.OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = strategy.get(transaction.getOperation());
            int currentQuantity = resultMap.getOrDefault(transaction.getFruitName(), 0);
            int newQuantity = handler.apply(currentQuantity, transaction.getQuantity());
            resultMap.put(transaction.getFruitName(), newQuantity);
        }
        return resultMap;
    }
}
