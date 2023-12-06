package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterToFileService;
import core.basesyntax.service.impl.DataProcessingServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteToFileServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_NAME = "src/main/resources/input.csv";

    public static void main(String[] args) {

        Map<FruitTransaction.Operation, OperationHandler>
                operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationHandlerMap);

        FruitDao fruitDao = new FruitDaoImpl();

        ReaderService readService = new ReaderServiceImpl();
        List<String> returnReadMethod = readService.read(FILE_NAME); // 1 method

        DataProcessingService processingService =
                new DataProcessingServiceImpl(fruitDao, operationStrategy); // 2 method
        Map<String, Integer> returnProcessingMethod = processingService.getFruit(returnReadMethod);

        ReportService reportingService = new ReportServiceImpl();
        String report = reportingService.getReport(returnProcessingMethod); // 3 method

        WriterToFileService writerToFileService = new WriteToFileServiceImpl();
        writerToFileService.writeReportToFile(report); // 4 method

    }
}
