package core.basesyntax.strategy.handlers;

import core.basesyntax.exceptions.FruitsNameException;
import core.basesyntax.exceptions.FruitsQuantityException;
import core.basesyntax.storage.Storage;
import java.util.Objects;

public class BalanceDataHandler implements DataHandler {
    // b , banana, 1234

    @Override
    public void processData(String fruit, int quantity) {
        if (fruit == null || fruit.isEmpty()) {
            throw new FruitsNameException("Wrong fruit name: "
                    + fruit);
        }
        if (quantity < 0) {
            throw new FruitsQuantityException("Wrong fruit quantity for "
                    + fruit
                    + ", quantity: "
                    + quantity);
        }
        Storage.addFruits(fruit, quantity);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
