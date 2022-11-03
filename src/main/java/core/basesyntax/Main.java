package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportGenerationService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReportGenerationServiceImpl;
import core.basesyntax.service.operations.BalanceOperationHandler;
import core.basesyntax.service.operations.PurchaseOperationHandler;
import core.basesyntax.service.operations.ReturnOperationHandler;
import core.basesyntax.service.operations.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_PATH = "src/main/resources/inputFileExample.csv";
    private static final String TO_FILE_PATH = "src/main/resources/reportExample.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> fruitTransactionMap = new HashMap<>();
        fruitTransactionMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        fruitTransactionMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        fruitTransactionMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        fruitTransactionMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(fruitTransactionMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.calculateFruits(FROM_FILE_PATH);
        ReportGenerationService reportGenerationService = new ReportGenerationServiceImpl();
        List<String> reportList = reportGenerationService.createReport(new FruitDaoImpl().getAll());
        reportGenerationService.saveReport(reportList, TO_FILE_PATH);
    }
}
