package core.basesyntax.service.operation;

import core.basesyntax.Main;

public class BalanceHandler implements OperationHandler {
    @Override
    public void process(String fruitName, int fruitQuantity) {
        Main.fruitMap.put(fruitName, fruitQuantity);
    }

}
