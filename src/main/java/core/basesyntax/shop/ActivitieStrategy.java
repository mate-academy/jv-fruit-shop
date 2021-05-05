package core.basesyntax.shop;

import core.basesyntax.handlers.Activity;

public interface ActivitieStrategy {
    Activity get(String action);
}
