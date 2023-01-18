package core.basesyntax.processing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitTransactionImpl implements FruitTransaction {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public Map<String, Integer> storage(List<String> activities) {
        Map<String, Integer> storageTemp = new HashMap<>();
        for (int i = 1; i < activities.size(); i++) {
            String[] activityArray = activities.get(i).split(",");
            switch (activityArray[OPERATION]) {
                case "p":
                    storageTemp.replace(activityArray[FRUIT], storageTemp.get(activityArray[FRUIT]),
                            storageTemp.get(activityArray[FRUIT])
                                    - Integer.parseInt(activityArray[QUANTITY]));
                    break;
                case "s":
                case "r":
                    storageTemp.replace(activityArray[FRUIT], storageTemp.get(activityArray[FRUIT]),
                            storageTemp.get(activityArray[FRUIT])
                                    + Integer.parseInt(activityArray[QUANTITY]));
                    break;
                case "b":
                default:
                    storageTemp.put(activityArray[FRUIT],
                            Integer.parseInt(activityArray[QUANTITY]));
                    break;
            }
        }
        return storageTemp;
    }
}
