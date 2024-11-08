package core.basesyntax.model;

public class FruitTransaction extends AbstractTransaction<Fruit> {
    public FruitTransaction(Fruit fruit, int count, OperationType activity) {
        super(fruit, count, activity);
    }
}
