package core.basesyntax.service.activity.strategy;

import core.basesyntax.model.FruitActivity;
import core.basesyntax.service.exceptions.InvalidFruitsQuantityException;

public interface ActivityHandler {

    void processActivity(FruitActivity fruitActivity);

    default void validateActivity(FruitActivity fruitActivity) {
        if (fruitActivity == null) {
            throw new NullPointerException("Cant handle null activity");
        }
        if (fruitActivity.getQuantity() == null || fruitActivity.getQuantity() < 0) {
            throw new InvalidFruitsQuantityException(
                    "Invalid quantity for activity. Quntity is " + fruitActivity.getQuantity());
        }
    }
}
