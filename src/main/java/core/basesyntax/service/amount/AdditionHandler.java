package core.basesyntax.service.amount;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.FruitStorage;
import java.util.Map;

public class AdditionHandler implements AmountHandler {
    private static final Map<String, Integer> FRUIT_COUNT = FruitStorage.FRUIT_COUNT;

    @Override
    public void apply(FruitRecord record) {
        String fruitName = record.getFruit().getFruitName();
        int currentAmount = FRUIT_COUNT.get(fruitName) == null
                ? 0 : FRUIT_COUNT.get(fruitName);
        int updatedAmount = currentAmount + record.getAmount();
        FRUIT_COUNT.put(fruitName, updatedAmount);
    }
}
