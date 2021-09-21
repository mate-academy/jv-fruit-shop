package core.basesyntax.service.amount;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.FruitStorage;
import java.util.Map;

public class SubtractionHandler implements AmountHandler {
    private static final Map<String, Integer> FRUIT_COUNT = FruitStorage.FRUIT_COUNT;

    @Override
    public void apply(FruitRecord record) {
        String fruitName = record.getFruit().getFruitName();
        int currentAmount = FRUIT_COUNT.get(fruitName) == null
                ? 0 : FRUIT_COUNT.get(fruitName);
        int updatedAmount = currentAmount - record.getAmount();
        if (updatedAmount < 0) {
            throw new RuntimeException("It isn't possible to buy fruits!"
                    + System.lineSeparator()
                    + "Is available: " + currentAmount
                    + " " + fruitName
                    + System.lineSeparator()
                    + "Trying to buy: " + record.getAmount()
                    + " " + fruitName);
        }
        FRUIT_COUNT.put(fruitName, updatedAmount);
    }
}
