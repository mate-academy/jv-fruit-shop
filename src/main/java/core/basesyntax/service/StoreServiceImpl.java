package core.basesyntax.service;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.operations.Operations;
import core.basesyntax.strategy.OperationStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoreServiceImpl implements StoreService {
    private static final String CSV_SEPARATOR = ",";
    private static final String TITLE = "fruit,quantity";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int INDEX_OF_DATA_START = 1;
    private final OperationStrategy operationStrategy;
    private final ProductDao productDao;

    public StoreServiceImpl(OperationStrategy operationStrategy, ProductDao productDao) {
        this.operationStrategy = operationStrategy;
        this.productDao = productDao;
    }

    @Override
    public void addToStorage(List<String> dataFromFile) {
        for (int i = INDEX_OF_DATA_START; i < dataFromFile.size(); i++) {
            String[] data = dataFromFile.get(i).split(CSV_SEPARATOR);
            Product product = new Product(data[FRUIT_INDEX]);
            int oldValue = productDao.get(product);

            String operationType = data[OPERATION_INDEX].toUpperCase();
            if (!Operations.contains(operationType)) {
                throw new RuntimeException("Incorrect operation try something else"
                        + operationType);
            }
            int value = Integer.parseInt(data[QUANTITY_INDEX]);
            if (value < 0) {
                throw new RuntimeException("The value can't be less than 0");
            }
            int newValue = operationStrategy.get(Operations.valueOf(operationType))
                    .calculateValue(oldValue, value);

            productDao.add(product, newValue);
        }
    }

    @Override
    public String getTheReportFromTheStorage() {
        List<String> data = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE);
        Map<Product, Integer> products = productDao.getAll();
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(entry.getKey().getName()
                    + CSV_SEPARATOR + entry.getValue());
        }
        return stringBuilder.toString();
    }
}
