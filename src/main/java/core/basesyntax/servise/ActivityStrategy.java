package core.basesyntax.servise;

import core.basesyntax.servise.activity.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler getActivity(String activity);
}
