package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperationDto;
import core.basesyntax.operations.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void saveToStorage(List<FruitOperationDto> fruitOperationDtoList) {
        for (FruitOperationDto fruitOperationDto : fruitOperationDtoList) {
            Storage.storage.put(fruitOperationDto.getFruit(),
                    operationStrategy.getOperation(fruitOperationDto.getType().getShortOperation())
                            .changeQuantity(fruitOperationDto));
        }
    }

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit, quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : Storage.storage.entrySet()) {
            stringBuilder.append(fruitIntegerEntry.getKey().getName())
                    .append(",").append(fruitIntegerEntry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
