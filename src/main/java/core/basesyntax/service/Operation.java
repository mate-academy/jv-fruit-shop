package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import java.util.Map;
import java.util.Objects;

public abstract class Operation {
    OperationType type;
    FruitBox fruitBox;

    public Operation(OperationType type, FruitBox fruit) {
        this.type = type;
        this.fruitBox = fruit;
    }

    public abstract Map<String, FruitBox> changeQuantity(int totalAmount,
                                                         Map<String, FruitBox> storage);

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operation operation = (Operation) o;
        return type == operation.type
                && Objects.equals(fruitBox, operation.fruitBox);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruitBox);
    }
}
