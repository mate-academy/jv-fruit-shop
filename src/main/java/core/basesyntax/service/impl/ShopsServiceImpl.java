package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.ValidationException;
import core.basesyntax.model.FruitOperationDto;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ShopsService;
import java.util.List;

public class ShopsServiceImpl implements ShopsService {
    private static final int gag = 0;
    private OperationStrategy operationStrategy;

    public ShopsServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void updateStorage(List<FruitOperationDto> dtos) {
        for (FruitOperationDto dto : dtos) {
            if (!Storage.fruitStorage.containsKey(dto.getFruitName())) {
                Storage.fruitStorage.put(dto.getFruitName(), gag);
            }
        }
        for (FruitOperationDto dto : dtos) {
            try {
                operationStrategy.get(dto.getType()).handler(dto);
            } catch (ValidationException e) {
                throw new RuntimeException("Type operation invalid.");
            }
        }

    }
}
