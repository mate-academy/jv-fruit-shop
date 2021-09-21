package core.basesyntax.impl;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    @Override
    public boolean validateRecord(FruitRecordDto record) {
        if (record.getAmount() <= 0 || record.getType() == null || record.getFruit() == null) {
            throw new RuntimeException("Record have mistakes "
                    + record.getType() + ", " + record.getFruit().getName() + ", "
            + record.getAmount());
        }
        return true;
    }
}
