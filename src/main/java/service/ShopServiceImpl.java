package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> getRepport(List<FruitTransaction> fruitTransactions) {
        Map<String,Integer> mapReport = new HashMap<>();

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .performToReport(fruitTransaction,mapReport);
        }
        return mapReport;
    }
}
