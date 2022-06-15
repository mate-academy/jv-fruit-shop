package core.basesyntax.service.imp;

import core.basesyntax.model.ProductTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TransactionParserImp implements TransactionParser {
    private static final String SPLITERATOR = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final Map<String, ProductTransaction.Operation> OPERATION_MAP = new HashMap<>();

    static {
        ProductTransaction.Operation[] arrayOfAllOperation = ProductTransaction.Operation.values();
        Arrays.stream(arrayOfAllOperation).forEach(x -> OPERATION_MAP.put(x.getOperation(), x));
    }

    @Override
    public ProductTransaction parse(String line) {
        String[] elements = line.split(SPLITERATOR);
        if (!OPERATION_MAP.containsKey(elements[INDEX_OF_OPERATION])) {
            throw new RuntimeException("Incorrect type of activity: " + line);
        }
        int quantity = Integer.parseInt(elements[INDEX_OF_QUANTITY]);
        if (quantity <= 0) {
            throw new RuntimeException("Incorrect quantity: " + line);
        }
        ProductTransaction.Operation operation = OPERATION_MAP.get(elements[INDEX_OF_OPERATION]);
        String nameOfProduct = elements[INDEX_OF_NAME];
        return new ProductTransaction(operation, nameOfProduct, quantity);
    }
}
