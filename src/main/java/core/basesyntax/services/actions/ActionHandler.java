package core.basesyntax.services.actions;

import core.basesyntax.exception.ValidationDataException;
import java.util.Map;

public interface ActionHandler {
    Map.Entry<String, Integer> actionStore(Map<String, Integer> copyDataFrmDB,
                                           String nameOfGoods, Integer valueOfTask);

    default void test(Map<String, Integer> copyDataFrmDB, String nameOfGoods) {
        if (copyDataFrmDB.isEmpty()) {
            throw new ValidationDataException("Task error db is empty");
        }
        if (copyDataFrmDB.get(nameOfGoods) == null) {
            throw new ValidationDataException("Client cant buy not exist product!");
        }
    }
}
