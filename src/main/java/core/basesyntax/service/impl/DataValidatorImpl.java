package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataValidator;

public class DataValidatorImpl implements DataValidator {
    @Override
    public boolean isValidDataFromCsv(String[] data) {
        if (data.length != 3) {
            return false;
        }
        FruitTransaction.Operation[] operations = FruitTransaction.Operation.values();
        boolean valid = false;
        for (FruitTransaction.Operation operation : operations) {
            if (data[SplitServiceImpl.Index.TYPE.ordinal()].equals(operation.getOperation())) {
                valid = true;
                break;
            }
        }
        return valid && data[SplitServiceImpl.Index.QUANTITY.ordinal()].matches("\\d+");
    }
}
