package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.validator.DataValidator;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private static final int DATA_LENGTH = 3;
    private static final int LIST_START = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final DataValidator validator;

    public DataConverterImpl(DataValidator validator) {
        this.validator = validator;
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputData) {
        validator.validate(inputData);
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : inputData.subList(LIST_START, inputData.size())) {
            String[] partsOfData = line.split(COMMA);
            if (partsOfData.length != DATA_LENGTH) {
                throw new IllegalArgumentException("Incorrect input data " + line);
            }

            try {
                Operation fruitOperation = Operation
                        .getOperationByCode(partsOfData[OPERATION_INDEX]);
                String fruit = partsOfData[FRUIT_INDEX];
                int quantity = Integer.parseInt(partsOfData[QUANTITY_INDEX]);
                fruitTransactions.add(new FruitTransaction(fruitOperation, fruit, quantity));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid data " + line
                        + " - " + e.getMessage());
            }
        }
        return fruitTransactions;
    }
}
