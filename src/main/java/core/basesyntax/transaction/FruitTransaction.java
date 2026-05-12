package core.basesyntax.transaction;

import core.basesyntax.strategy.handler.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String code, String fruit, int quantity) {
        this.operation = Operation.fromCode(code);
        this.fruit = fruit;
        this.quantity = quantity;
    }
}
