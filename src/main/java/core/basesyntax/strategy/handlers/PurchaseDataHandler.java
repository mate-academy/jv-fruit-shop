package core.basesyntax.strategy.handlers;

import core.basesyntax.exceptions.FruitsQuantityException;
import core.basesyntax.storage.Storage;
import java.util.Objects;

public class PurchaseDataHandler implements DataHandler {

    @Override
    public void processData(String fruit, int quantity) {
        validatePurchaseData(fruit, quantity);
        Storage.addFruits(fruit, Storage.getFruits(fruit) - quantity);
    }

    public void validatePurchaseData(String fruit, int quantity) {
        if ((fruit != null
                && !fruit.isEmpty()
                && quantity > Storage.getFruits(fruit))
                || quantity < 0) {
            throw new FruitsQuantityException("Wrong fruit quantity for "
                    + fruit
                    + ", quantity: "
                    + quantity
                    + " and storage: "
                    + Storage.getFruits(fruit));
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
