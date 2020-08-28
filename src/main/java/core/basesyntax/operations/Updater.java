package core.basesyntax.operations;

import core.basesyntax.dao.Storage;
import core.basesyntax.goods.Product;
import java.time.LocalDate;
import java.util.*;

public class Updater {
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_TYPE_INDEX = 1;
    private static final int EXP_DATE_INDEX = 2;
    private static final int QUANTITY_INDEX = 3;
    private static final String CSV_REGEX = ", ";
    private final OperationSwitcher switcher = new OperationSwitcher();

    public Storage parseData(List<String> inputData, Storage storage) {
        for (String line : inputData) {
            String[] data = line.split(CSV_REGEX);
            Product product = new Product(data[PRODUCT_TYPE_INDEX],
                    LocalDate.parse(data[EXP_DATE_INDEX]),
                    Integer.parseInt(data[QUANTITY_INDEX]));
            switcher.getOperation(data[OPERATION_INDEX])
                    .updateStorage(product, storage);
        }
        return storage;
    }
}
