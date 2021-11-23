package core.basesyntax.service;

import core.basesyntax.model.Activity;
import java.nio.file.Path;
import java.util.List;

public interface ReaderService {
    List<Activity> read(Path path);
}
