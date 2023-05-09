package core.basesyntax.service;

import core.basesyntax.stretegy.Strategy;
import core.basesyntax.stretegy.StrategyImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseImpl implements Warehouse {
    private final Map<String, Integer> remains;
    private final List<FruitTransaction> dayOperations;

    public WarehouseImpl(List<FruitTransaction> dayOperations) {
        this.remains = new HashMap<>();
        this.dayOperations = new ArrayList<>();
        Strategy strategy = new StrategyImpl();
        for (FruitTransaction dayOperation : dayOperations) {
            strategy.getHandler(dayOperation.getOperation()).warehouseOperation(
                    dayOperation.getFruit(), dayOperation.getQuantity(), this);
        }
    }

    @Override
    public Map<String, Integer> getRemains() {
        return remains;
    }

    @Override
    public List<FruitTransaction> getDayOperations() {
        return dayOperations;
    }
 }
