package validator;

import model.FruitRecord;

public class ValidatorImpl implements Validator {
    @Override
    public boolean validateRecord(FruitRecord record) {
        if (record.getAmount() <= 0 || record.getType() == null || record.getFruit() == null) {
            throw new RuntimeException("Record have mistakes "
                    + record.getType() + ", " + record.getFruit().getName() + ", "
            + record.getAmount());
        }
        return true;
    }
}
