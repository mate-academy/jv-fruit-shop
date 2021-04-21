package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.operations.Operations;
import core.basesyntax.strategy.OperationsStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    public static final String TITLE = "fruit,quantity";
    public static final String SEPARATOR = ",";
    public static final int TYPE_INDEX = 0;
    public static final int PRODUCT_NAME_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;
    private final OperationsStrategy operationStrategy;

    public ProductServiceImpl(OperationsStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void addToStorage(List<String> dataFromFile) {
        for (String line : dataFromFile) {
            String[] data = line.split(SEPARATOR);
            operationStrategy.get(Operations.valueOf(data[TYPE_INDEX].toUpperCase()))
                    .perform(new Product(data[PRODUCT_NAME_INDEX]),
                            Integer.parseInt(data[AMOUNT_INDEX]));
        }
    }

    @Override
    public List<String> getFromStorage() {
        List<String> data = new ArrayList<>();
        data.add(TITLE);
        Map<Product, Integer> products = Storage.getProducts();
        for (Map.Entry<Product, Integer> productIntegerEntry : products.entrySet()) {
            data.add(System.lineSeparator());
            data.add(productIntegerEntry.getKey().getName()
                    + SEPARATOR + productIntegerEntry.getValue());
        }
        return data;
    }
}
