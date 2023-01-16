package core.basesyntax.service.implementations;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operationhandler.OperationHandler;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    private static final String REPORT_TEMPLATE = "fruit,quantity";
    private static final int OPERATION_FIELD = 0;
    private static final int FRUIT_NAME_FIELD = 1;
    private static final int FRUIT_QUANTITY_FIELD = 2;

    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void processData(List<String> activities, OperationStrategy operationStrategy) {

        for (String lines : activities) {
            FruitTransaction fruitTransaction =
                            getTransactionFromCsvRow(lines);
            OperationHandler operationHandler =
                            operationStrategy.get(fruitTransaction.getOperation());
            operationHandler.makeOperation(fruitTransaction.getFruit(),
                            fruitTransaction.getQuantity(), storageDao);
        }
    }

    @Override
    public String provideReport() {
        return REPORT_TEMPLATE + storageDao.toString();
    }

    private FruitTransaction getTransactionFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(fields[OPERATION_FIELD]);
        fruitTransaction.setFruit(fields[FRUIT_NAME_FIELD]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[FRUIT_QUANTITY_FIELD]));
        return fruitTransaction;
    }
}
