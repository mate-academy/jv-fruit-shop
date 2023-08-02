package core.basesyntax.services;

import core.basesyntax.model.Task;
import java.util.List;

public interface ProcessStoreService {
    boolean processAction(List<Task> tasks);
}
