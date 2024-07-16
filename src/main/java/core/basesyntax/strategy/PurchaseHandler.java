package core.basesyntax.strategy;

import core.basesyntax.db.FruitTransaction;
import java.util.List;

public class PurchaseHandler implements OperationHandler {
    private static final String PURCHASE = "p";

    @Override
    public List<FruitTransaction> getFruitFinalQuantity(List<FruitTransaction> listOfAll,
                                                        List<FruitTransaction> listOfFruits) {
        for (FruitTransaction listOfFruit : listOfFruits) {
            int oldQuantity = 0;
            for (FruitTransaction fruitTransaction : listOfAll) {
                if (listOfFruit.getFruit().equals(fruitTransaction.getFruit())
                        && fruitTransaction.getType().equals(PURCHASE)) {
                    int quantity = fruitTransaction.getQuantity();
                    listOfFruit.setQuantity(quantity + oldQuantity);
                    oldQuantity = quantity;
                }
            }
        }
        return listOfFruits;
    }
}
