package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransactionImpl;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int PARTS_LENGTH = 3;
    private static final int OPERATION_PART = 0;
    private static final int FRUIT_PART = 1;
    private static final int QUANTITY_PART = 2;
    private static final String COMMA = ",";

    @Override
    public List<FruitTransactionImpl> convertToTransaction(List<String> inputReport) {
        List<FruitTransactionImpl> fruitTransactionList = new ArrayList<>();

        for (String line : inputReport) {
            if (line == null || line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(COMMA);

            if (parts.length != PARTS_LENGTH) {
                continue;
            }

            try {
                FruitTransactionImpl fruitTransactionImpl = new FruitTransactionImpl();
                fruitTransactionImpl.setOperation(FruitTransactionImpl
                        .Operation.getOperationByCode(parts[OPERATION_PART]));
                fruitTransactionImpl.setFruit(parts[FRUIT_PART]);
                fruitTransactionImpl.setQuantity(Integer.parseInt(parts[QUANTITY_PART]));
                fruitTransactionList.add(fruitTransactionImpl);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid number in record: " + line);
            }
        }
        return fruitTransactionList;
    }
}
