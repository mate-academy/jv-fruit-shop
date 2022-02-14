package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.ReportWriterService;
import core.basesyntax.service.impl.DataProcessingServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.ReportReaderServiceImpl;
import core.basesyntax.service.impl.ReportWriterServiceImpl;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationService;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationService;
import core.basesyntax.strategy.impl.ReturnOperationService;
import core.basesyntax.strategy.impl.SupplyOperationService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFruitStorage {
    private static final String INPUT_FILE_PATH = "src/main/resources/input_report.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/output_report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationService> operationServiceMap
                = getOperationServiceMap();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationServiceMap);
        List<FruitTransaction> fruitTransactions = new ReportReaderServiceImpl()
                .readFile(INPUT_FILE_PATH);
        DataProcessingService dataProcessingService
                = new DataProcessingServiceImpl(operationStrategy);
        dataProcessingService.processingDate(fruitTransactions);
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        String report = reportCreatorService.createReport();
        ReportWriterService reportWriterService = new ReportWriterServiceImpl();
        reportWriterService.writeReport(report, REPORT_FILE_NAME);
    }

    private static Map<FruitTransaction.Operation, OperationService> getOperationServiceMap() {
        Map<FruitTransaction.Operation, OperationService> operationServiceMap = new HashMap<>();
        operationServiceMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationService());
        operationServiceMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationService());
        operationServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationService());
        operationServiceMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationService());
        return operationServiceMap;
    }
}
