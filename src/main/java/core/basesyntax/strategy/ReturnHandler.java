package core.basesyntax.strategy;

import core.basesyntax.db.FruitTransaction;
import java.util.List;

public class ReturnHandler implements OperationHandler {
    private static final String RETURN = "r";

    @Override
    public List<FruitTransaction> getFruitFinalQuantity(List<FruitTransaction> listOfAll,
                                                        List<FruitTransaction> listOfFruits) {
        for (FruitTransaction listOfFruit : listOfFruits) {
            int oldQuantity = 0;
            for (FruitTransaction fruitTransaction : listOfAll) {
                if (listOfFruit.getFruit().equals(fruitTransaction.getFruit())
                        && fruitTransaction.getType().equals(RETURN)) {
                    int quantity = fruitTransaction.getQuantity();
                    listOfFruit.setQuantity(quantity + oldQuantity);
                    oldQuantity = quantity;
                }
            }
        }
        return listOfFruits;
    }
}
