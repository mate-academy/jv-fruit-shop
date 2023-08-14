package core.basesyntax.service.counter;

import core.basesyntax.models.Fruit;
import java.util.Map;

public class BalanceTypeImpl implements OperationType {

    @Override
    public void countFruits(Map<Fruit, Integer> dataToUpdateReport, Map<String,
            Fruit> fruitTypes, String string) {
        String[] split = string.split(",");
        Fruit fruitType = fruitTypes.get(split[FRUIT_TYPE]);
        int fruitQuantity = Integer.parseInt(split[FRUIT_QUANTITY]);
        dataToUpdateReport.put(fruitType, fruitQuantity);
    }
}
