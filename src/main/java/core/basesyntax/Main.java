package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.ReportWriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ProcessDataServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.ReportWriterServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
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
                new BalanceOperationHandler(new FruitDaoImpl()));
        fruitTransactionMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(new FruitDaoImpl()));
        fruitTransactionMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(new FruitDaoImpl()));
        fruitTransactionMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(new FruitDaoImpl()));

        OperationStrategy operationStrategy = new OperationStrategyImpl(fruitTransactionMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy,
                new ProcessDataServiceImpl());
        fruitService.calculateFruits(FROM_FILE_PATH);
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        List<String> reportList = reportCreatorService.createReport(new FruitDaoImpl().getAll());
        ReportWriterService reportWriterService = new ReportWriterServiceImpl();
        reportWriterService.saveReport(reportList, TO_FILE_PATH);
    }
}
