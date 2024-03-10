package core.basesyntax.service;

import core.basesyntax.model.Event;
import java.util.List;

public interface IFileReader {
    List<Event> read(String path);
}
