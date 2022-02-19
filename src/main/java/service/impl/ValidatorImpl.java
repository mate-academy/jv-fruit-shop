package service.impl;

import java.util.Arrays;
import java.util.List;
import service.Validator;

public class ValidatorImpl implements Validator {
    private static final int FIRST_VALUE_LINE = 1;
    private static final int LENGTH_VALUE_LINE = 3;
    private static final int FRUIT_COUNT_LINE_INDEX = 2;
    private static final String LINE_SEPARATOR = ",";

    @Override
    public void validateInformation(List<String> information) {
        for (int i = FIRST_VALUE_LINE; i < information.size(); i++) {
            String[] inputArray = information.get(i).split(LINE_SEPARATOR);
            checkLength(inputArray);
            checkCount(inputArray);
            checkNull(information);
        }
    }

    private void checkLength(String[] inputArray) {
        if (inputArray.length != LENGTH_VALUE_LINE) {
            throw new IllegalArgumentException("Not enough values" + Arrays.toString(inputArray));
        }
    }

    private void checkCount(String[] inputArray) {
        if (Integer.parseInt(inputArray[FRUIT_COUNT_LINE_INDEX]) < 0) {
            throw new IllegalArgumentException("Needed positive values");
        }
    }

    private void checkNull(List<String> information) {
        if (information == null) {
            throw new IllegalArgumentException("No data found");
        }
    }
}

