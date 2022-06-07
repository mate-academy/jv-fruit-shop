package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImp;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.impl.BalanceOperationHandler;
import core.basesyntax.operation.impl.PurchaseOperationHandler;
import core.basesyntax.operation.impl.ReturnOperationHandler;
import core.basesyntax.operation.impl.SupplyOperationHandler;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ParseStatisticService;
import core.basesyntax.service.ReportWriterService;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvReportWriterService;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ParseStatisticServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImp();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap
                .put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitDao));
        operationHandlerMap
                .put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(fruitDao));
        operationHandlerMap
                .put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler(fruitDao));
        operationHandlerMap
                .put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FileReaderService fileReaderService = new CsvFileReaderService();
        List<String> dataFromFile = fileReaderService.read();
        ParseStatisticService parseStatisticService = new ParseStatisticServiceImpl();
        List<FruitTransaction> fruitTransactionStatistic
                = parseStatisticService.getFruitTransactionStatistic(dataFromFile);
        FruitTransactionService fruitTransactionService
                = new FruitTransactionServiceImpl(fruitDao, operationStrategy);
        fruitTransactionService.transaction(fruitTransactionStatistic);
        CreateReportService createReport = new CreateReportServiceImpl();
        String report = createReport.createReport();
        ReportWriterService reportWriterService = new CsvReportWriterService();
        reportWriterService.writeReport(report);
    }
}

