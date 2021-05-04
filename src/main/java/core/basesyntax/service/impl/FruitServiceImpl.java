package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<Operation, FruitOperationHandler> operations;

    public FruitServiceImpl(Map<Operation, FruitOperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public Map<String, Integer> getFruitReport() {
        Map<String, Integer> fruits = new HashMap<>();
        for (Map.Entry<Fruit, Integer> entry : Storage.getFruits().entrySet()) {
            fruits.put(entry.getKey().getFruitName(), entry.getValue());
        }
        return fruits;
    }

    @Override
    public void applyOperation(List<FruitRecordDto> fruitRecordDtoList) {
        for (FruitRecordDto fruitRecordDto : fruitRecordDtoList) {
            operations.get(fruitRecordDto.getOperationType()).apply(fruitRecordDto);
        }
    }
}
