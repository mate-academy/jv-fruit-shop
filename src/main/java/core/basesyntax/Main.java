package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitsService;
import core.basesyntax.service.FruitsServiceImpl;
import core.basesyntax.service.csvfileservice.ReaderService;
import core.basesyntax.service.csvfileservice.WriterService;
import core.basesyntax.service.operationsservice.BalanceFruitOperation;
import core.basesyntax.service.operationsservice.FruitOperation;
import core.basesyntax.service.operationsservice.PurchaseFruitOperation;
import core.basesyntax.service.operationsservice.ReturnFruitOperation;
import core.basesyntax.service.operationsservice.SupplyFruitOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, FruitOperation> operationsMap = new HashMap<>();
        FruitsDao fruitsDao = new FruitsDaoImpl();
        operationsMap.put(FruitTransaction.Operation.BALANCE, new BalanceFruitOperation(fruitsDao));
        operationsMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseFruitOperation(fruitsDao));
        operationsMap.put(FruitTransaction.Operation.RETURN, new ReturnFruitOperation(fruitsDao));
        operationsMap.put(FruitTransaction.Operation.SUPPLY, new SupplyFruitOperation(fruitsDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsMap);

        FruitsService fruitsService = new FruitsServiceImpl(new FruitsDaoImpl(),
                operationStrategy, new ReaderService(), new WriterService());

        fruitsService.generateFruitsReport();
    }
}




