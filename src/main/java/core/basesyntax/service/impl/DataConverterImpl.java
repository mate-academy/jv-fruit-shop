package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.InputDataValidation;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY_OF_FRUITS = 2;
    private final InputDataValidation inputDataValidation = new InputDataValidationImpl();

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> listFromFile) {
        inputDataValidation.validate(listFromFile);
        return listFromFile.stream()
                .filter(s -> s.startsWith(FruitTransaction.Operation.BALANCE.getCode())
                        || s.startsWith(FruitTransaction.Operation.SUPPLY.getCode())
                        || s.startsWith(FruitTransaction.Operation.PURCHASE.getCode())
                        || s.startsWith(FruitTransaction.Operation.RETURN.getCode()))
                .map(s -> s.split(","))
                .map(s -> new FruitTransaction(s[OPERATION_TYPE],
                                                s[FRUIT_NAME],
                                                Integer.parseInt(s[QUANTITY_OF_FRUITS])))
                .toList();
    }
}
