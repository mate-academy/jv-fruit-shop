package core.basesyntax.strategy;

import core.basesyntax.service.activity.ActivityOperation;
import core.basesyntax.service.activity.TypeActivity;

public interface ActivityStrategy {
    ActivityOperation get(TypeActivity type);
}
