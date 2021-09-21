package dao;

public class ValidatorImpl implements Validator {
    private static final int MAX_LENGTH = 3;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public void validator(String[] fileDataLine) {
        if (fileDataLine.length != MAX_LENGTH
                || Integer.parseInt(fileDataLine[AMOUNT_INDEX]) < 0) {
            throw new RuntimeException("Incorrect data in file");
        }
    }
}