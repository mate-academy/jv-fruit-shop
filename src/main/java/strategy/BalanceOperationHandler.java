package strategy;

import model.Fruit;
import storege.Storege;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void apply(Fruit fruit, int quantity) {
        Storege.data.put(fruit, quantity);
    }
}
