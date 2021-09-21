package core.basesyntax.service.validators;

import core.basesyntax.exceptions.InputException;
import java.util.ArrayList;
import java.util.List;

public class InputValidatorImpl implements InputValidator {
    private static final int HEAD_STRING = 0;
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String TYPE = "type";
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String REGEX = ",";

    @Override
    public void validate(List<String> data) throws InputException {
        String head = data.get(HEAD_STRING);
        headValidation(head);
        List<String> dataToValidate = new ArrayList<>(List.copyOf(data));
        dataToValidate.remove(HEAD_STRING);
        for (String activity : dataToValidate) {
            activityValidation(activity);
        }
    }

    private void headValidation(String head) throws InputException {
        String[] headElements = baseValidationAndSplitter(head);
        if (!TYPE.equals(headElements[ACTIVITY_TYPE_INDEX])
                || !FRUIT.equals(headElements[FRUIT_INDEX])
                || !QUANTITY.equals(headElements[AMOUNT_INDEX])) {
            throw new InputException("input head is invalid");
        }
    }

    private void activityValidation(String activity) throws InputException {
        String[] activityElements = baseValidationAndSplitter(activity);
        if (activityElements[ACTIVITY_TYPE_INDEX].isEmpty()
                || activityElements[FRUIT_INDEX].isEmpty()
                || activityElements[AMOUNT_INDEX].isEmpty()
                || Integer.parseInt(activityElements[AMOUNT_INDEX]) < 0) {
            throw new InputException("activity parameters were invalid");
        }
    }

    private String[] baseValidationAndSplitter(String dataLine) throws InputException {
        if (dataLine == null) {
            throw new InputException("dataLine was null!");
        }
        String[] lineElements;
        if ((lineElements = dataLine.split(REGEX)).length != 3) {
            throw new InputException("invalid number of elements in dataLine");
        }
        return lineElements;
    }
}
