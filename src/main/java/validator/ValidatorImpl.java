package validator;

public class ValidatorImpl implements Validator {
    @Override
    public void validate(String input) {
        String[] rowToCheck = input.split(",");
        if (rowToCheck.length < 3 || Integer.parseInt(rowToCheck[2]) < 0) {
            throw new RuntimeException("This file contains invalid data, unable to process");
        }
    }
}
