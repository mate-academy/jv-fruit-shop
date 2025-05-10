package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    static final int TRANSACTIONS_START_INDEX = 1;
    static final int OPERATION_INDEX = 0;
    static final int FRUIT_INDEX = 1;
    static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> readerOutput) {
        if (readerOutput.isEmpty()) {
            return new ArrayList<>();
        }
        List<FruitTransaction> converterOutput = new ArrayList<>();
        for (int i = TRANSACTIONS_START_INDEX; i < readerOutput.size(); i++) {
            String[] parts = readerOutput.get(i).split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Incorrect format of data");
            }
            int quantity;
            try {
                quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity format of given quantity: "
                        + parts[QUANTITY_INDEX]);
            }
            converterOutput.add(new FruitTransaction(
                    getOperation(parts[OPERATION_INDEX]),
                    parts[FRUIT_INDEX].trim(),
                    quantity
            ));
        }
        return converterOutput;
    }

    private FruitTransaction.Operation getOperation(String operationCode) {
        return FruitTransaction.Operation.fromCode(operationCode);
    }
}
