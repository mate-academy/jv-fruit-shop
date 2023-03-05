package core.basesyntax.service.impl;

import core.basesyntax.db.StockBalance;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateData;
import core.basesyntax.strategy.FruitsCalculatorStrategy;
import java.util.List;

public class CalculateDataServiceImpl implements CalculateData {
    private FruitsCalculatorStrategy fruitsCalculatorStrategy;

    @Override
    public void create(List<FruitTransaction> list) {
        fruitsCalculatorStrategy = new FruitsCalculatorStrategy();
        for (FruitTransaction itemList : list) {
            if (!StockBalance.STOCK_BALANCE.containsKey(itemList.getFruit())
                    && itemList.getOperation() == FruitTransaction.Operation.BALANCE) {
                int newQuantity = fruitsCalculatorStrategy.putPreviousPeriodQuantity(
                        itemList.getQuantity(), itemList.getOperation());
                StockBalance.STOCK_BALANCE.put(itemList.getFruit(), newQuantity);
            } else {
                int newQuantity = fruitsCalculatorStrategy.calculateQuantity(
                        StockBalance.STOCK_BALANCE.get(itemList.getFruit()),
                        itemList.getQuantity(), itemList.getOperation());
                StockBalance.STOCK_BALANCE.put(itemList.getFruit(), newQuantity);
            }
        }
    }
}
