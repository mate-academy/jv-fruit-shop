package core.basesyntax.strategy.handlers;

import core.basesyntax.storage.Storage;
import java.util.Objects;

public class SupplyDataHandler implements DataHandler {

    @Override
    public void processData(String fruit, int quantity) {
        Storage.addFruits(fruit, Storage.getFruits(fruit) + quantity);
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
