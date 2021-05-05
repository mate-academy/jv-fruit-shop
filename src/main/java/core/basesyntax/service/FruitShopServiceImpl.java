package core.basesyntax.service;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dto.FruitRecordDto;
import java.util.List;
import java.util.stream.Collectors;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String DEFAULT_START = "fruit,quantity" + System.lineSeparator();
    private final FruitShopDao fruitShopDao;
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(FruitShopDao fruitShopDao, OperationStrategy operationStrategy) {
        this.fruitShopDao = fruitShopDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void saveData(List<FruitRecordDto> data) {
        data.forEach(record -> operationStrategy.get(record.getOperationType())
                .updateBalance(record.getFruit()));
    }

    @Override
    public String getReport() {
        return DEFAULT_START + fruitShopDao.getAll().stream()
                .map(fruit -> String.format("%s,%d",
                        fruit.getName(), fruit.getAmount()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
