package core.basesyntax.service.convertator;

import core.basesyntax.model.FruitTransaction;

public class DataConvertorImpl implements DataConvertor {
    private static final int INDEX_TYPE_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final String SPLIT_REGEX = ",";

    @Override
    public FruitTransaction convertData(String data) {
        return new FruitTransaction(convertOperation(data.split(SPLIT_REGEX)[INDEX_TYPE_OPERATION]),
                data.split(SPLIT_REGEX)[INDEX_FRUIT_NAME],
                Integer.parseInt(data.split(SPLIT_REGEX)[INDEX_QUANTITY]));
    }

    private FruitTransaction.Operation convertOperation(String operation) {
        return switch (operation) {
            case "b" -> FruitTransaction.Operation.BALANCE;
            case "p" -> FruitTransaction.Operation.PURCHASE;
            case "r" -> FruitTransaction.Operation.RETURN;
            case "s" -> FruitTransaction.Operation.SUPPLY;
            default -> throw new RuntimeException("Convertation is failed: " + operation);
        };
    }

}
