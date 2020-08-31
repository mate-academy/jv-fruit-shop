package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitDto;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitOperation;
import core.basesyntax.service.FruitService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private Map<Operation, FruitOperation> operationType;

    public FruitServiceImpl(Map<Operation, FruitOperation> operationType) {
        this.operationType = operationType;

    }

    @Override
    public void makeOperationsOnFruitsDto(List<FruitDto> fruitDtos) {
        for (FruitDto fruitDto : fruitDtos) {
            operationType.get(fruitDto.getOperation()).apply(fruitDto);
        }
    }

    @Override
    public Map<String, Long> gerFruitReport() {
        return Storage.fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getName, Collectors.counting()));
    }
}
