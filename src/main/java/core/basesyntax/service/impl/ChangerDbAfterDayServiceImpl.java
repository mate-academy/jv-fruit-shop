package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.service.ChangerDbAfterDayService;
import core.basesyntax.service.GetterFruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ChangerDbAfterDayServiceImpl implements ChangerDbAfterDayService {
    private final ReaderService readerService;
    private final OperationStrategy operationStrategy;
    private final GetterFruitTransaction getterFruitTransaction;
    private FruitsDao fruitsDao;

    public ChangerDbAfterDayServiceImpl(ReaderService readerService,
                                        OperationStrategy operationStrategy,
                                        GetterFruitTransaction getterFruitTransaction,
                                        FruitsDao fruitsDao) {
        this.readerService = readerService;
        this.operationStrategy = operationStrategy;
        this.getterFruitTransaction = getterFruitTransaction;
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void changeDb(String fileName) {
        List<String[]> records = readerService.getActivities(fileName);
        records.stream()
                .map(getterFruitTransaction::getFruitTransaction)
                .forEach(t -> fruitsDao.put(t.getFruit(),
                        operationStrategy.get(t.getOperation())
                                .newAmount(fruitsDao.get(t.getFruit()), t.getQuantity())));
    }
}
