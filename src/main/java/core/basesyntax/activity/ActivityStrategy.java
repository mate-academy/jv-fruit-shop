package core.basesyntax.activity;

import core.basesyntax.service.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler getActivity(String activity);
}
