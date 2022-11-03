package core.basesyntax.handler.impl;

import core.basesyntax.handler.Supply;
import java.util.HashMap;

public class SupplyImpl implements Supply {
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public void supply(String[] info, HashMap<String, Integer> storage) {
        storage.put(info[FRUIT_NAME_INDEX],
                    storage.get(info[FRUIT_NAME_INDEX])
                            + Integer.parseInt(info[FRUIT_AMOUNT_INDEX]));
    }
}
