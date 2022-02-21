import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.initializer.Initializer;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.impl.BalanceOperationImpl;
import core.basesyntax.service.operation.impl.PurchaseOperationImpl;
import core.basesyntax.service.operation.impl.ReturnOperationImpl;
import core.basesyntax.service.operation.impl.SupplyOperationImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String reportPath
                = "C:\\Users\\Igor\\IdeaProjects\\jv-fruit-shop\\src\\main\\resources\\report.csv";
        Storage storage = new Storage();
        FruitDao<String, Integer> fruitDao = new FruitDaoImpl(storage);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationImpl(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationImpl(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationImpl(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationImpl(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl(fruitDao, reportPath);
        Initializer initializer = new Initializer(fruitService, operationStrategy);
        initializer.initStorage();
        fruitService.createReport();
    }
}
