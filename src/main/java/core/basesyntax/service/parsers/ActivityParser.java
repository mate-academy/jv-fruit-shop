package core.basesyntax.service.parsers;

import core.basesyntax.model.Activity;

public interface ActivityParser {
    Activity parse(String line);
}
