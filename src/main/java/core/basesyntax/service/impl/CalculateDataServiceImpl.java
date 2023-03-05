package core.basesyntax.service.impl;

import core.basesyntax.db.StockBalance;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateDataForReport;
import core.basesyntax.strategy.FruitsCalculatorStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateDataForReportServiceImpl implements CalculateDataForReport {

    @Override
    public void create(List<FruitTransaction> list) {
        FruitsCalculatorStrategy fruitsCalculatorStrategy = new FruitsCalculatorStrategy();
        for (FruitTransaction itemList : list) {
            if (!StockBalance.STOCK_BALANCE.containsKey(itemList.getFruit())) {
                StockBalance.STOCK_BALANCE.put(itemList.getFruit(), new FruitsCalculatorStrategy()
                        .calculateQuantity(0, itemList.getQuantity(), itemList.getOperation()));
            } else {
                int newQuantity = fruitsCalculatorStrategy
                        .calculateQuantity(StockBalance.STOCK_BALANCE.get(itemList.getFruit()),itemList.getQuantity(),itemList.getOperation());
                StockBalance.STOCK_BALANCE.put(itemList.getFruit(), newQuantity);
            }
        }
    }
}
