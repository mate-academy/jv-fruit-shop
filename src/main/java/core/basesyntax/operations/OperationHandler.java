package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import java.util.Map;

public interface OperationHandler {

    Map<String, Integer> getCalculation(
            Map<String, Integer> fruits, FruitTransaction fruitTransaction);

}
