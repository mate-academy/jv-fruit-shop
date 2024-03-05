package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.activity.ActivityHandler;
import core.basesyntax.service.activity.BalanceActivityHandler;
import core.basesyntax.service.activity.PurchaseActivityHandler;
import core.basesyntax.service.activity.ReturnActivityHandler;
import core.basesyntax.service.activity.SupplyActivityHandler;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.ActivityStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, ActivityHandler> activityHandlerMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceActivityHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseActivityHandler(),
                FruitTransaction.Operation.RETURN, new ReturnActivityHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyActivityHandler());
        FruitDaoImpl fruitDao = new FruitDaoImpl();
        ReportService reportService = new ReportService(fruitDao);
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);
        OperationService operationService = new OperationService(activityStrategy, fruitDao);
        FileService fileService = new FileService();
        List<String> stringList = fileService.readFromFile(INPUT_FILE_NAME);
        List<FruitTransaction> fruitTransactions =
                TransactionService.convertToTransactionsList(stringList);
        operationService.executeOperations(fruitTransactions);
        String report = reportService.generateReport();
        fileService.writeReport(OUTPUT_FILE_NAME, report);
    }
}
