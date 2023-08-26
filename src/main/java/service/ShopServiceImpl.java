package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void getRepport(List<FruitTransaction> from, Map<String, Integer> to) {
        for (FruitTransaction fruitTransaction : from) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .performToReport(fruitTransaction,to);
        }
    }
}
