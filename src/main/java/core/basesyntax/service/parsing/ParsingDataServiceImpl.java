package core.basesyntax.service.parsing;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.operationwithfruits.BalanceOperationHandler;
import core.basesyntax.service.operationwithfruits.OperationHandler;
import core.basesyntax.service.operationwithfruits.PurchaseOperationHandler;
import core.basesyntax.service.operationwithfruits.ReturnOperationHandler;
import core.basesyntax.service.operationwithfruits.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParsingDataServiceImpl implements ParsingDataService {
    private static final int OPERATOR = 0;
    private static final int FRUIT = 1;
    private static final int FRUIT_COUNT = 2;
    private StorageDao storageDao = new StorageDaoImpl();
    private OperationStrategy operationStrategy;

    @Override
    public void parsingFromList(List<String> fruits) {
        Map<String, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put("b", new BalanceOperationHandler());
        operationHandlersMap.put("p", new PurchaseOperationHandler());
        operationHandlersMap.put("r", new ReturnOperationHandler());
        operationHandlersMap.put("s", new SupplyOperationHandler());
        operationStrategy = new OperationStrategyImpl(operationHandlersMap);
        fruits.stream().skip(1).forEach(this::parsingLine);
    }

    private void parsingLine(String line) {
        String[] splitLines = line.split(",");
        int count = operationStrategy.get(splitLines[OPERATOR])
                .getOperation(Integer.parseInt(splitLines[FRUIT_COUNT]));
        storageDao.update(splitLines[1], storageDao.getCountFruit(splitLines[FRUIT]) + count);
    }
}
