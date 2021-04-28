package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordStrategy;
import core.basesyntax.service.FruitService;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();
    private final FruitRecordStrategy fruitRecordStrategy;
    private final FruitDao fruitDao;

    public FruitServiceImpl(FruitRecordStrategy fruitRecordStrategy, FruitDao fruitDao) {
        this.fruitRecordStrategy = fruitRecordStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public void saveData(List<FruitRecordDto> fruitRecords) {
        fruitRecords.forEach(activity -> fruitRecordStrategy.get(activity.getType())
                .changeBalance(activity.getFruit()));
    }

    @Override
    public String getFruitReport() {
        return TITLE + fruitDao.getAll().stream()
                .map(fruit -> String.format("%s,%d",
                        fruit.getName(), fruit.getAmount()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
