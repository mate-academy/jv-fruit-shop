package core.basesyntax.service;

import core.basesyntax.strategy.Activity;

public interface ActivityParser {
    Activity parse(String line);
}
