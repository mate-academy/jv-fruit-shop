package core.basesyntax.service.fileservice;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private static final int HEADER = 1;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .skip(HEADER)
                .map(s -> s.split(COMMA))
                .map(parts -> {
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setOperation(
                            Operation.getOperationByCode(parts[INDEX_OF_OPERATION]));
                    fruitTransaction.setFruit(parts[INDEX_OF_FRUIT]);
                    int fruitQuantity = Integer.parseInt(parts[INDEX_OF_QUANTITY]);
                    if (fruitQuantity < 0) {
                        throw new IllegalArgumentException("Quantity can't be less than " + 0);
                    }
                    fruitTransaction.setQuantity(fruitQuantity);
                    return fruitTransaction;
                })
                .toList();
    }
}
