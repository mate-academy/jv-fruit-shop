package core.basesyntax.services.actions;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.ValidationDataException;

public interface ActionHandler {
    boolean actionStore(String nameOfGoods, Integer valueOfTask);

    default void validData(Storage fruitDB, String nameOfGoods) {
        if (fruitDB == null) {
            throw new ValidationDataException("ActionHandle error db is null");
        }
        if (fruitDB.getStorageFruits().isEmpty()) {
            throw new ValidationDataException("ActionHandle error db is empty");
        }
        if (fruitDB.getStorageFruits().get(nameOfGoods) == null) {
            throw new ValidationDataException("Client cant buy not exist product!");
        }
    }
}
