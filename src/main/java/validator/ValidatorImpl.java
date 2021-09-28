package validator;

import java.util.List;

public class ValidatorImpl implements Validator {
    @Override
    public void validate(List<String> input) {
        for (String element : input) {
            String[] rowToCheck = element.split(",");
            if (rowToCheck.length != 3 || Integer.parseInt(rowToCheck[2]) < 0) {
                throw new RuntimeException("This file contains invalid data, unable to process");
            }
        }
    }
}
