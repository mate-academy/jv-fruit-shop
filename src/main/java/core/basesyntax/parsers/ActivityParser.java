package core.basesyntax.parsers;

import core.basesyntax.model.Activity;

public interface ActivityParser {
    Activity parse(String line);
}
