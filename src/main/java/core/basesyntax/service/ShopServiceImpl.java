package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private static Map<String, OperationHandler> operationHandlesMap = new HashMap<>();
    private static OperationStrategy operationStrategy =
            new OperationStrategyImpl(operationHandlesMap);
    private FruitDao fruitDao;
    private FruitService fruitService;

    public ShopServiceImpl(FruitDao fruitDao, FruitService fruitService,
                           OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.fruitService = fruitService;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processing(String rowInfo) {
        String fruitName = rowInfo.split(",")[1];
        int valueOfOperation = Integer.parseInt(rowInfo.split(",")[2]);
        int quantity = fruitDao.get(fruitName).getQuantity();
        int operation = operationStrategy.get(rowInfo.split(",")[0]).getOperation();
        if ((operation == -1 || operation == 0) && valueOfOperation > quantity) {
            throw new RuntimeException("Can't processing operation "
                    + rowInfo.split(",")[0] + " with value " + valueOfOperation
            + ". Our shop has " + quantity + " " + fruitName + "s.");
        }
        fruitDao.update(fruitName,quantity + (operation * valueOfOperation));
    }
}
