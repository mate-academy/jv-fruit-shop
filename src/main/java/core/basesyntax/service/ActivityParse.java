package core.basesyntax.service;

import core.basesyntax.model.Activity;

public interface ActivityParse {
    Activity toActivity(String string);
}
