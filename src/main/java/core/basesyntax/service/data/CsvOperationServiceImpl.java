package core.basesyntax.service.data;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class CsvOperationServiceImpl implements OperationService<FruitTransaction> {
    private FruitDao fruitDao;
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public CsvOperationServiceImpl(FruitDao fruitDao,
                                   Map<FruitTransaction.Operation,
                                           OperationHandler> operationHandlerMap) {
        this.fruitDao = fruitDao;
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void processOperation(List<FruitTransaction> fruitTransactions) {
        fruitDao.clear();
        fruitTransactions
                .forEach(o -> operationHandlerMap
                        .get(o.getOperation()).handle(o.getFruit(), o.getQuantity()));
    }
}
