package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.validation.DataValidator;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private final DataValidator validator;

    public DataConverterImpl(DataValidator validator) {
        this.validator = validator;
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputData) {
        validator.validate(inputData);
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        for (String line : inputData.subList(1, inputData.size())) {
            String[] partsOfData = line.split(",");
            Operation fruitOperation = Operation.valueOf(partsOfData[0]);
            String fruit = partsOfData[1];
            int quantity = Integer.parseInt(partsOfData[2]);
            fruitTransactions.add(new FruitTransaction(fruitOperation, fruit, quantity));
        }
        return fruitTransactions;
    }
}
