package core.basesyntax.strategy;

import core.basesyntax.db.FruitTransaction;
import java.util.List;

public interface OperationHandler {
    List<FruitTransaction> getFruitFinalQuantity(List<FruitTransaction> list,
                                                 List<FruitTransaction> listOfFruits);
}
