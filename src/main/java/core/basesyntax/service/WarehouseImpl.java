package core.basesyntax.service;

import core.basesyntax.strategy.Strategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseImpl implements Warehouse {
    private final Map<String, Integer> remains;
    private final List<FruitTransaction> dayOperations;

    public WarehouseImpl(List<FruitTransaction> dayOperations, Strategy strategy) {
        this.remains = new HashMap<>();
        this.dayOperations = new ArrayList<>();
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
