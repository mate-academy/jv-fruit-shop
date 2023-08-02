package core.basesyntax.services;

import core.basesyntax.model.Task;
import java.util.List;

public interface CreateTaskService {
    List<Task> createTasks(ReadFileService dataFromFile, String sourcefile);
}
