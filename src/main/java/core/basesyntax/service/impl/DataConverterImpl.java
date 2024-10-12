package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.validation.DataValidator;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private final DataValidator validator;

    public DataConverterImpl(DataValidator validator) {
        this.validator = validator;
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputData) {
        validator.validate(inputData);
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : inputData) {
            String[] partsOfData = line.split(COMMA);
            if (partsOfData.length != 3) {
                throw new IllegalArgumentException("Incorrect input data format in line: " + line);
            }

            try {
                Operation fruitOperation = getOperationByCode(partsOfData[0]);
                String fruit = partsOfData[1];
                int quantity = Integer.parseInt(partsOfData[2]);

                fruitTransactions.add(new FruitTransaction(fruitOperation, fruit, quantity));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid data in line: " + line
                        + " - " + e.getMessage());
            }
        }
        return fruitTransactions;
    }

    private Operation getOperationByCode(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("No enum constant for code: " + code);
    }
}
