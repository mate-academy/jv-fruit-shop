package core.basesyntax.service;

import core.basesyntax.model.Activity;
import core.basesyntax.service.activityhandler.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(Activity.Type type);
}
