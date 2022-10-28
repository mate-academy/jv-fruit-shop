package core.basesyntax.dao.impl;

import core.basesyntax.dao.ParseFruitAction;
import core.basesyntax.strategy.FruitShopTransaction;
import core.basesyntax.strategy.impl.FruitShopTransactionImpl;
import java.util.HashMap;
import java.util.Map;

public class ParseFruitActionImpl implements ParseFruitAction {
    private static final String WORDS_SPLITERATOR = ",";
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final FruitShopTransaction fruitShopTransaction;

    public ParseFruitActionImpl() {
        this.fruitShopTransaction = new FruitShopTransactionImpl();
    }

    @Override
    public Map<String, Integer> parseFruit(String[] activity) {
        Map<String, Integer> dataForReport = new HashMap<>();
        String[] activityData;
        String activityType;
        String fruit;
        int quantity;
        for (String data : activity) {
            activityData = data.split(WORDS_SPLITERATOR);
            activityType = activityData[ACTIVITY_TYPE_INDEX];
            fruit = activityData[FRUIT_INDEX];
            quantity = Integer.parseInt(activityData[QUANTITY_INDEX]);
            fruitShopTransaction.fruitTransaction(dataForReport, activityType, fruit, quantity);
        }
        return dataForReport;
    }
}
