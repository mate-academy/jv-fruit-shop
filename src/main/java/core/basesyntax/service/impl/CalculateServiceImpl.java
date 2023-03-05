package core.basesyntax.service.impl;

import core.basesyntax.db.StockBalance;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateService;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class CalculateServiceImpl implements CalculateService {
    private OperationHandlerStrategy operationHandlerStrategy;

    @Override
    public void create(List<FruitTransaction> list) {
        operationHandlerStrategy = new OperationHandlerStrategy();
        for (FruitTransaction itemList : list) {
            if (!StockBalance.STOCK_BALANCE.containsKey(itemList.getFruit())
                    && itemList.getOperation() == FruitTransaction.Operation.BALANCE) {
                int newQuantity = operationHandlerStrategy.calculateQuantity(
                        0, itemList.getQuantity(), itemList.getOperation());
                StockBalance.STOCK_BALANCE.put(itemList.getFruit(), newQuantity);
            } else {
                int newQuantity = operationHandlerStrategy.calculateQuantity(
                        StockBalance.STOCK_BALANCE.get(itemList.getFruit()),
                        itemList.getQuantity(), itemList.getOperation());
                StockBalance.STOCK_BALANCE.put(itemList.getFruit(), newQuantity);
            }
        }
    }
}
