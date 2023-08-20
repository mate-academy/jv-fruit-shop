package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CreateTaskService {
    List<FruitTransaction> createTasks(List<String[]> parseData);
}
