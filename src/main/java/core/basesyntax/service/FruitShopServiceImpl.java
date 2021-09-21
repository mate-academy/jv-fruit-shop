package core.basesyntax.service;

import core.basesyntax.db.DataBaseFruit;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.operation.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String COLUMN_NAMES = "fruit,quantity";
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(COLUMN_NAMES)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : DataBaseFruit.storage.entrySet()) {
            stringBuilder.append(fruitIntegerEntry.getKey())
                    .append(",")
                    .append(fruitIntegerEntry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public void save(List<FruitRecordDto> fruitRecordDtos) {
        for (FruitRecordDto fruitRecordDto : fruitRecordDtos) {
            String typeOperation = fruitRecordDto.getType();
            DataBaseFruit.storage.put(fruitRecordDto.getFruit(),
                    operationStrategy
                            .getHandel(typeOperation)
                            .changeAmount(fruitRecordDto,
                                    DataBaseFruit.storage));
        }
    }
}
