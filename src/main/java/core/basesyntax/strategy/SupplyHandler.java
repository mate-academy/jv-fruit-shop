package core.basesyntax.strategy;

import core.basesyntax.db.FruitTransaction;
import java.util.List;

public class SupplyHandler implements OperationHandler {
    private static final String SUPPLY = "s";

    @Override
    public List<FruitTransaction> getFruitFinalQuantity(List<FruitTransaction> listOfAll,
                                                        List<FruitTransaction> listOfFruits) {
        for (FruitTransaction listOfFruit : listOfFruits) {
            int oldQuantity = 0;
            for (FruitTransaction fruitTransaction : listOfAll) {
                if (listOfFruit.getFruit().equals(fruitTransaction.getFruit())
                        && fruitTransaction.getType().equals(SUPPLY)) {
                    int quantity = fruitTransaction.getQuantity();
                    listOfFruit.setQuantity(quantity + oldQuantity);
                    oldQuantity = quantity;
                }
            }
        }
        return listOfFruits;
    }
}
