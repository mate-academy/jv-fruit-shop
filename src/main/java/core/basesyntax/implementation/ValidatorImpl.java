package core.basesyntax.implementation;

import core.basesyntax.Record;
import core.basesyntax.exceptions.ValidationException;
import core.basesyntax.service.Validator;
import java.util.List;

public class ValidatorImpl implements Validator {
    @Override
    public void validate(List<Record> recordsList) {
        for (Record record : recordsList) {
            if (record.getActivity() == null
                    || record.getFruit() == null
                    || record.getAmount() < 0) {
                try {
                    throw new ValidationException("Invalid input data");
                } catch (ValidationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
