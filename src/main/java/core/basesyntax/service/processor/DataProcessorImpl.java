package core.basesyntax.service.processor;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    private static final String NAMING_FOR_COLUM_CSV_FILE = "fruit,quantity"
            + System.lineSeparator();
    private final OperationStrategy operationStrategy;
    private final StorageDao storageDao = new StorageDaoImpl();

    public DataProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public String calculateData(List<FruitTransaction> fruitTransactionList) {
        if (fruitTransactionList.isEmpty()) {
            throw new RuntimeException("Fruit list is empty " + fruitTransactionList);
        }

        for (FruitTransaction fruit : fruitTransactionList) {
            operationStrategy.get(fruit.getOperation()).getHandler(fruit);
        }

        StringBuilder stringBuilder = new StringBuilder(NAMING_FOR_COLUM_CSV_FILE);
        for (FruitTransaction fruit : storageDao.getAll()) {
            stringBuilder.append(fruit.getFruit())
                    .append(",")
                    .append(fruit.getQuantity())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
