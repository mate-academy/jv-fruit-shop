package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertService;
import java.util.Map;

public class ConvertServiceImpl implements ConvertService {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_PRODUCT_NAME = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final String SEPARATOR = ",";
    private static final Map<String, FruitTransaction.Operation> STRING_OPERATION_MAP = Map.of(
            "b", FruitTransaction.Operation.BALANCE,
            "s", FruitTransaction.Operation.SUPPLY,
            "p", FruitTransaction.Operation.PURCHASE,
            "r", FruitTransaction.Operation.RETURN);

    @Override
    public FruitTransaction convertToFruitTransaction(String transaction) {
        String[] splitData = transaction.split(SEPARATOR);
        return new FruitTransaction(STRING_OPERATION_MAP.get(splitData[INDEX_OF_OPERATION]),
                splitData[INDEX_OF_PRODUCT_NAME],
                Integer.parseInt(splitData[INDEX_OF_AMOUNT]));
    }
}
