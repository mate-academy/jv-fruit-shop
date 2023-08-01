package core.basesyntax.services;

import core.basesyntax.model.Task;
import java.util.List;

public interface ProcessStoreService {
    void processAction(List<Task> tasks);
}
