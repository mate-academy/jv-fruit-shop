package core.basesyntax.service.implementation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitRecordDtoCreator;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;

public class FruitShopServiceImpl implements FruitShopService {
    private final FruitDao fruitDao;
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void updateStorage(String fileName, FruitRecordDtoCreator fruitRecordDtoCreator) {
        for (FruitRecordDto record : fruitRecordDtoCreator.parseRecords(fileName)) {
            OperationHandler operationHandler = operationStrategy.get(record.getTypeOfOperation());
            Integer newAmountValue = operationHandler.calculateNewAmount(fruitDao,
                    record.getFruit(), record.getAmount());
            fruitDao.update(record.getFruit(), newAmountValue);
        }
    }
}
