package core.basesyntax.service.impl;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataProcessService;
import core.basesyntax.strategy.FruitOperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.FruitOperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class DataProcessServiceImpl implements DataProcessService {
    private final Map<Operation, OperationHandler> operationPicker;
    private final StorageDao storageDao;

    public DataProcessServiceImpl(Map<Operation, OperationHandler> operationPicker) {
        this.operationPicker = operationPicker;
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void processFruits(List<FruitTransaction> fruits) {
        List<String> fruitNames = fruits.stream()
                .map(FruitTransaction::getFruitName)
                .distinct()
                .toList();

        FruitOperationStrategy fruitOperationStrategy =
                new FruitOperationStrategyImpl(operationPicker);

        for (String fruitName : fruitNames) {
            int fruitCount = 0;
            for (FruitTransaction fruitTransaction : fruits) {
                if (fruitTransaction.getFruitName().equals(fruitName)) {
                    fruitCount += fruitOperationStrategy.countFruits(fruitTransaction);
                }
            }

            if (fruitCount < 0) {
                throw new RuntimeException("Cannot be less then 0: " + fruitCount);
            }

            storageDao.add(fruitName, fruitCount);
        }
    }
}
