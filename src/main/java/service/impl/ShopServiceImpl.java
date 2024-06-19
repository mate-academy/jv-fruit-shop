package service.impl;

import db.Storage;
import java.util.List;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            if (!Storage.reports.containsKey(transaction.getFruit())) {
                Storage.reports.put(transaction.getFruit(), getHowManyHaveChanged(transaction));
            } else {
                if (getBalance(transaction) + getHowManyHaveChanged(transaction) >= 0) {
                    Storage.reports.put(transaction.getFruit(), getBalance(transaction)
                            + getHowManyHaveChanged(transaction));
                } else {
                    throw new RuntimeException("The quantity at shop is not enough to purchase");
                }
            }
        }
    }

    private int getHowManyHaveChanged(FruitTransaction transaction) {
        return operationStrategy.getOperationHandler(transaction.getOperation())
                .apply(transaction.getQuantity());
    }

    private int getBalance(FruitTransaction transaction) {
        return Storage.reports.get(transaction.getFruit());
    }
}
