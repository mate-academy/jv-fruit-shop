package core.basesyntax;

import java.util.Map;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class FruitOperation {
    OperationType type;
    Transaction transaction;

    public abstract Map<String, Transaction> execute(int totalQuantity,
                                                     Map<String, Transaction> storage);
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitOperation fruitOperation = (FruitOperation) o;
        return type == fruitOperation.type
                && Objects.equals(transaction, fruitOperation.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, transaction);
    }
}
