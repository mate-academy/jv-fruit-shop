package app.service;

import static app.constants.Constants.FRUIT;
import static app.constants.Constants.QUANTITY;
import static app.constants.Constants.SEPARATOR;
import static app.constants.Constants.TYPE;

import app.enums.FruitNames;
import app.enums.OperationTypes;

public class LineValidatorImpl implements LineValidator {

    @Override
    public boolean isValid(String line) {
        if (line.length() > 0) {
            String[] data = line.split(SEPARATOR);
            return dataValidatorType(data[TYPE])
                    && dataValidatorFruit(data[FRUIT])
                    && dataValidatorQuantity(data[QUANTITY]);
        }
        return false;
    }

    private boolean dataValidatorType(String type) {
        try {
            OperationTypes.valueOf(type);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean dataValidatorFruit(String fruit) {
        try {
            FruitNames.valueOf(fruit);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean dataValidatorQuantity(String quantity) {
        try {
            return Integer.parseInt(quantity) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
