package core.basesyntax;

import java.util.Map;

public class FruitServisImpl implements FruitOperations {
    @Override
    public void balanceFruit(FruitListOperation operation, Map<String, Fruit> fruits) {
        fruits.put(operation.getFruit().getName(), operation.getFruit());
    }

    @Override
    public void supplyFruit(FruitListOperation operation, Map<String, Fruit> fruits) {
        Fruit fruit = new Fruit(operation.getFruit().getName(), operation.getFruit().getQuantity()
                + fruits.get(operation.getFruit().getName()).getQuantity());
        fruits.put(operation.getFruit().getName(), fruit);
    }

    @Override
    public void purchaseFruit(FruitListOperation operation, Map<String, Fruit> fruits) {
        Fruit fruit = new Fruit(operation.getFruit().getName(),
                fruits.get(operation.getFruit().getName()).getQuantity()
                - operation.getFruit().getQuantity());
        fruits.put(operation.getFruit().getName(), fruit);
    }

    @Override
    public void returnFruit(FruitListOperation operation, Map<String, Fruit> fruits) {
        Fruit fruit = new Fruit(operation.getFruit().getName(),
                operation.getFruit().getQuantity()
                + fruits.get(operation.getFruit().getName()).getQuantity());
        fruits.put(operation.getFruit().getName(), fruit);
    }
}
