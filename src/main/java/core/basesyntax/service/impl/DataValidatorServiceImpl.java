package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;

public class DataValidatorServiceImpl {
    public static final int OPERATION = 0;
    public static final int FRUIT_NAME = 1;
    public static final int QUALITY = 2;

    public boolean checkDataInput(String[] data) {
        if (data.length != 3) {
            return false;
        }
        if (data[FRUIT_NAME].equals("")
                || data[FRUIT_NAME].equals(" ")) {
            return false;
        }
        if (Integer.parseInt(data[QUALITY]) < 0) {
            return false;
        }
        return data[OPERATION].equals("b")
                || data[OPERATION].equals("s")
                || data[OPERATION].equals("p")
                || data[OPERATION].equals("r");
    }
}
