package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordStrategy;
import core.basesyntax.service.FruitService;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();
    private final FruitRecordStrategy fruitRecordStrategy;

    public FruitServiceImpl(FruitRecordStrategy fruitRecordStrategy) {
        this.fruitRecordStrategy = fruitRecordStrategy;
    }

    @Override
    public void saveData(List<FruitRecordDto> fruitRecords) {
        fruitRecords.forEach(activity -> fruitRecordStrategy.get(activity.getType())
                .changeBalance(activity.getFruit()));
    }

    @Override
    public String getFruitReport() {
        return TITLE + Storage.storage.values().stream()
                .map(fruit -> String.format("%s,%d",
                        fruit.getName(), fruit.getAmount()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
