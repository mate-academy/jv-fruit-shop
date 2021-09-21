package dao;

public class ValidatorImpl implements Validator {
    private static final int MAX_LENGTH = 3;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public void validate(String[] dataFromFile) {
        if (dataFromFile.length != MAX_LENGTH
                || Integer.parseInt(dataFromFile[AMOUNT_INDEX]) < 0) {
            throw new RuntimeException("Incorrect data in file");
        }
    }
}