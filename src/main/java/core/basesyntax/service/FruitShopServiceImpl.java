package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperationDto;
import core.basesyntax.operations.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String HEAD = "fruit, quantity";
    private static final String SPLITERATOR_REGEX = ",";
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void saveToStorage(List<FruitOperationDto> fruitOperationDtoList) {
        for (FruitOperationDto fruitOperationDto : fruitOperationDtoList) {
            Storage.storage.put(fruitOperationDto.getFruit(),
                    operationStrategy.getOperation(fruitOperationDto.getType().getShortOperation())
                            .apply(fruitOperationDto));
        }
    }

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(HEAD)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : Storage.storage.entrySet()) {
            stringBuilder.append(fruitIntegerEntry.getKey().getName())
                    .append(SPLITERATOR_REGEX).append(fruitIntegerEntry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
