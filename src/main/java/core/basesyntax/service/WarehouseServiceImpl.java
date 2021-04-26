package core.basesyntax.service;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.operations.Operations;
import core.basesyntax.strategy.OperationsStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WarehouseServiceImpl implements WarehouseService {
    public static final String TITLE = "fruit,quantity";
    public static final String SEPARATOR = ",";
    public static final int TYPE_INDEX = 0;
    public static final int PRODUCT_NAME_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;
    public static final int INDEX_OF_DATA_START = 1;
    private final OperationsStrategy operationStrategy;
    private final ProductDao productDao;

    public WarehouseServiceImpl(OperationsStrategy operationStrategy, ProductDao productDao) {
        this.operationStrategy = operationStrategy;
        this.productDao = productDao;
    }

    @Override
    public void addToStorage(List<String> dataFromFile) {
        for (int i = INDEX_OF_DATA_START; i < dataFromFile.size(); i++) {
            String[] data = dataFromFile.get(i).split(SEPARATOR);
            Product product = new Product(data[PRODUCT_NAME_INDEX]);
            int oldAmount = productDao.get(product);

            String operationTypeName = data[TYPE_INDEX].toUpperCase();
            if (!Operations.contains(operationTypeName)) {
                throw new RuntimeException("There is no operation of such type "
                        + operationTypeName);
            }
            int amount = Integer.parseInt(data[AMOUNT_INDEX]);
            if (amount < 0) {
                throw new RuntimeException("Amount can't be less than zero");
            }
            int newAmount = operationStrategy.get(Operations.valueOf(operationTypeName))
                    .calculateAmount(oldAmount, amount);

            productDao.add(product, newAmount);
        }
    }

    @Override
    public String getReportFromStorage() {
        List<String> data = new ArrayList<>();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE);
        Map<Product, Integer> products = productDao.getAll();
        for (Map.Entry<Product, Integer> productIntegerEntry : products.entrySet()) {
            reportBuilder.append(System.lineSeparator());
            reportBuilder.append(productIntegerEntry.getKey().getName()
                    + SEPARATOR + productIntegerEntry.getValue());
        }
        return reportBuilder.toString();
    }
}
