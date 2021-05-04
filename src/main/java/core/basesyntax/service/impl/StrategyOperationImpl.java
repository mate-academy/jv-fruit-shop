package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.StrategyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrategyOperationImpl implements StrategyOperation {
    private Map<String, FruitOperationHandler> handlers;

    public StrategyOperationImpl(Map<String, FruitOperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public Map<String, Integer> get(List<FruitRecordDto> fruitRecordDtos) {
        Map<String, Integer> balanceForDay = new HashMap<>();
        for (FruitRecordDto dto: fruitRecordDtos) {
            int apply = handlers.get(dto.getOperationType()).apply(dto);
            balanceForDay.put(dto.getFruitName(), apply);
        }
        return balanceForDay;
    }
}
