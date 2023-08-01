package core.basesyntax.services;

import core.basesyntax.functions.ReadFile;
import core.basesyntax.model.Task;
import java.util.List;

public interface CreateTaskService {
    List<Task> createTasks(ReadFile dataFromFile, String sourcefile);
}
