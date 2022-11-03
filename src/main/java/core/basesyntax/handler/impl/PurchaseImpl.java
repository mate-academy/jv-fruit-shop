package core.basesyntax.handler.impl;

import core.basesyntax.handler.Purchase;
import java.util.HashMap;

public class PurchaseImpl implements Purchase {
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public void purchase(String[] info, HashMap<String, Integer> storage) {
        storage.put(info[FRUIT_NAME_INDEX],
                    storage.get(info[FRUIT_NAME_INDEX])
                            - Integer.parseInt(info[FRUIT_AMOUNT_INDEX]));
    }
}
