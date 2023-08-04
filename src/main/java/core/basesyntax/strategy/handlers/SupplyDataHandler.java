package core.basesyntax.strategy.handlers;

import core.basesyntax.exceptions.FruitsNameException;
import core.basesyntax.storage.Storage;
import java.util.Objects;

public class SupplyDataHandler implements DataHandler {

    @Override
    public void processData(String fruit, int quantity) {
        validateSupplyData(fruit, quantity);
        Storage.addFruits(fruit, Storage.getFruits(fruit) + quantity);
    }

    private void validateSupplyData(String fruit, int quantity) {
        if (fruit == null || fruit.isEmpty()) {
            throw new FruitsNameException("Wrong fruit name: "
                    + fruit);
        }
        if (quantity < 0) {
            throw new RuntimeException("Wrong fruit quantity for "
                    + fruit
                    + ", quantity: "
                    + quantity);
        }
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
