package core.basesyntax.service;

import java.util.List;

public class GetDataFromListOfActivityImpl implements GetDataFromListOfActivity {
    private static final int FRUIT_INDEX = 0;
    private static final int AMOUNT_INDEX = 1;

    @Override
    public String getFruitName(String string) {
        return string.split(",")[FRUIT_INDEX];
    }

    @Override
    public int getFruitAmount(String string) {
        return Integer.parseInt(string.split(",")[AMOUNT_INDEX]);
    }
}
