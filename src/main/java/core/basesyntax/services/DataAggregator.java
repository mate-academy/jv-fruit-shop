package core.basesyntax.services;

import core.basesyntax.items.Product;
import core.basesyntax.items.Storage;
import core.basesyntax.operations.Buy;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Supply;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataAggregator {
    public static final int OPERATION_SYMBOL_INDEX = 0;
    public static final int PRODUCT_TYPE_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final int DATE_INDEX = 3;
    private final LineParser parser = new LineParser();
    private final Map<String, Operation> storageOperations = new TreeMap<>();

    public DataAggregator() {
        storageOperations.put("s", new Supply());
        storageOperations.put("b", new Buy());
        storageOperations.put("r", new Supply());
    }

    public Storage aggregate(List<String> list, Storage storage) {
        for (String line : list) {
            String[] operationData = parser.parse(line);
            Product product = new Product(operationData[PRODUCT_TYPE_INDEX],
                    Integer.parseInt(operationData[QUANTITY_INDEX]),
                    LocalDate.parse(operationData[DATE_INDEX]));
            storageOperations.get(operationData[OPERATION_SYMBOL_INDEX])
                    .updateStorage(product, storage);
        }
        return storage;
    }
}
