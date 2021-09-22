package core.basesyntax.service.impl;

import core.basesyntax.exception.ValidationException;
import core.basesyntax.service.Validator;

import java.util.List;

public class FruitOperationDtoValidator implements Validator<String> {
    private static final int QUANTITY_FRUIT_INDEX = 2;

    @Override
    public void validate(List<String> dataFromFile) throws ValidationException {
        for (String value : dataFromFile) {
            if (value == null) {
                throw new ValidationException("FruitOperationDto hasn't data. String value is null");
            }
            String[] data = value.split(",");

            if (data.length != 3) {
                throw new ValidationException("Not enough data. Value: " + value);
            }
            if (Integer.parseInt(data[QUANTITY_FRUIT_INDEX]) < 0) {
                throw new ValidationException("Quantity could not be less than 0");
            }
        }
    }
}
