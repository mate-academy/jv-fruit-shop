package strategy;

import model.Fruit;
import storege.Storege;

public class PurchaseOperationHandlerImpl implements OperationHandler {

    @Override
    public void apply(Fruit fruit, int quantity) {
        if (Storege.data.get(fruit) - quantity < 0) {
            throw new RuntimeException("You can't bought this fruit");
        }
        Storege.data.put(fruit, Storege.data.get(fruit) - quantity);
    }
}
