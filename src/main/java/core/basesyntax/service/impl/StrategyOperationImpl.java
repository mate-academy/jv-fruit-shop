package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.StrategyOperation;
import java.util.List;
import java.util.Map;

public class StrategyOperationImpl implements StrategyOperation {
    private Map<String, FruitOperationHandler> handlers;

    public StrategyOperationImpl(Map<String, FruitOperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public Map<Fruit, Integer> get(List<FruitRecordDto> fruitRecordDtos) {
        Storage storage = new Storage();
        for (FruitRecordDto dto: fruitRecordDtos) {
            int quantity = handlers.get(dto.getOperationType()).apply(dto);
            storage.fruits.put(new Fruit(dto.getFruitName()), quantity);
        }
        return storage.fruits;
    }

}
