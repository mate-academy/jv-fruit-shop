package core.basesyntax.service;

import core.basesyntax.model.Event;
import java.util.List;

public interface IEventHandler {
    void convertList(List<Event> list);
}
