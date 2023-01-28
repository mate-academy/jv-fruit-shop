package core.basesyntax.service.impl;

public class DataValidatorServiceImpl implements DataValidatorService {
    public static final int OPERATION = 0;
    public static final int FRUIT_NAME = 1;
    public static final int QUALITY = 2;
    public static final int SIZE_TRANSLATION = 3;
    public static final int ZERO = 0;

    public boolean checkDataInput(String[] data) {
        if (data.length != SIZE_TRANSLATION
                || (data[FRUIT_NAME].isBlank()
                || data[FRUIT_NAME].isEmpty())
                || Integer.parseInt(data[QUALITY]) < 0
                || !(data[OPERATION].equals("b")
                || data[OPERATION].equals("s")
                || data[OPERATION].equals("p")
                || data[OPERATION].equals("r"))) {
            throw new RuntimeException("Incorrect input data ");
        }
        return true;
    }

    public boolean checkOperation(int money) {
        if (money < ZERO) {
            throw new RuntimeException("money ran out");
        }
        return true;
    }
}
