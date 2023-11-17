package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.service.strategy.impl.HandlerStrategy;
import java.util.List;
import java.util.Map;

public class ProcessDataServiceImpl implements ProcessDataService {
    private final StorageDao storageDao;
    private final HandlerStrategy handlerStrategy;

    public ProcessDataServiceImpl(StorageDao storageDao, HandlerStrategy handlerStrategy) {
        this.storageDao = storageDao;
        this.handlerStrategy = handlerStrategy;
    }

    @Override
    public Map<String, Integer> processing(List<FruitTransaction> operations) {
        for (FruitTransaction operation : operations) {
            storageDao.putToMap(operation.getFruit(),
                    handlerStrategy.getHandlerByOperationType(operation.getOperation())
                            .processTransaction(operation));
        }
        return storageDao.getAll();
    }
}
