package core.basesyntax.services.impl;

import core.basesyntax.dao.StoreDao;
import core.basesyntax.model.Task;
import core.basesyntax.services.ActionStrategy;
import core.basesyntax.services.ProcessStoreService;
import java.util.List;
import java.util.Map;

public class ProcessStoreServiceImpl implements ProcessStoreService {
    private static StoreDao storeDao;
    private static ActionStrategy actionStrategy;

    public ProcessStoreServiceImpl(StoreDao storeDao, ActionStrategy actionStrategy) {
        this.storeDao = storeDao;
        this.actionStrategy = actionStrategy;
    }

    @Override
    public void processAction(List<Task> tasks) {
        for (Task task : tasks) {
            Map.Entry<String, Integer> resultTaskComplete = actionStrategy.get(task.getType())
                    .actionStore(storeDao.getStorage(), task.getLabelGoods(), task.getValue());
            storeDao.add(resultTaskComplete.getKey(), resultTaskComplete.getValue());
        }
    }
}
