package core.basesyntax.services.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.services.InventoryService;
import core.basesyntax.services.operations.FruitOperationStrategy;
import java.util.List;

public class FruitInventoryService implements InventoryService {
    private FruitOperationStrategy strategy;

    public FruitInventoryService(FruitOperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void conductActivities(List<FruitTransactionDto> dtos) {
        for (var dto : dtos) {
            strategy.getHandler(dto).forEach(h -> h.apply(dto));
        }
    }
}
