package strategy;

import model.Fruit;
import storege.Storege;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(Fruit fruit, int quantity) {
        Storege.data.put(fruit, Storege.data.get(fruit) + quantity);
    }
}
