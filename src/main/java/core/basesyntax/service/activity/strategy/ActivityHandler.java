package core.basesyntax.service.activity.strategy;

import core.basesyntax.model.Activity;
import core.basesyntax.service.exceptions.InvalidQuantityException;

public interface ActivityHandler {

    void processActivity(Activity activity);

    default void validateActivity(Activity activity) {
        if (activity == null) {
            throw new NullPointerException("Cant handle null activity");
        }
        if (activity.getQuantity() == null || activity.getQuantity() < 0) {
            throw new InvalidQuantityException(
                    "Invalid quantity for activity. Quntity is " + activity.getQuantity());
        }
    }
}
