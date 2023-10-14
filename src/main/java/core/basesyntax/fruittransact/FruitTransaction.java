package core.basesyntax.fruittransact;

import core.basesyntax.fruittransact.strategy.FruitTransactionStrategy;
import java.util.List;

public class FruitTransaction {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private FruitTransactionStrategy fruitTransactionStrategy;

    public FruitTransaction(FruitTransactionStrategy fruitTransactionStrategy) {
        this.fruitTransactionStrategy = fruitTransactionStrategy;
    }

    public void handle(String type, String name, int amount) {
        FruitService fruitService = fruitTransactionStrategy.get(type);
        fruitService.handle(name, amount);
    }

    public void handleAll(List<String[]> data) {
        for (String[] datum : data) {
            handle(datum[TYPE_INDEX],
                    datum[FRUIT_INDEX],
                    Integer.parseInt(datum[AMOUNT_INDEX]));
        }
    }
}
