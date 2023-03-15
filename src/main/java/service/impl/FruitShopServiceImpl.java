package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.FruitShopService;
import strategy.ActivitiesStrategy;

public class FruitShopServiceImpl implements FruitShopService {
    private ActivitiesStrategy strategy;

    public FruitShopServiceImpl(ActivitiesStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            strategy.get(fruitTransaction.getOperationCharacter().trim())
                    .operation(fruitTransaction);
        }
    }
}
