package core.basesyntax.model;

public class FruitTransaction extends Transaction {
    public FruitTransaction(Operation operationType, String name, Integer quantity) {
        super(operationType, name, quantity);
    }
}
