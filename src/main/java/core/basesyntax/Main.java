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
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ParseStatisticService;
import core.basesyntax.service.ReportWriterService;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvReportWriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ParseStatisticServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String FILE_PATH = "./src/main/resources/input-file.csv";
    public static final String REPORT_PATH = "./src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImp();
        FruitService fruitService = new FruitServiceImpl(fruitDao);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap
                .put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitService));
        operationHandlerMap
                .put(FruitTransaction.Operation.PURCHASE,
                        new PurchaseOperationHandler(fruitDao, fruitService));
        operationHandlerMap
                .put(FruitTransaction.Operation.RETURN,
                        new ReturnOperationHandler(fruitDao, fruitService));
        operationHandlerMap
                .put(FruitTransaction.Operation.SUPPLY,
                        new SupplyOperationHandler(fruitDao, fruitService));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FileReaderService fileReaderService = new CsvFileReaderService();
        List<String> dataFromFile = fileReaderService.read(FILE_PATH);
        ParseStatisticService parseStatisticService = new ParseStatisticServiceImpl();
        List<FruitTransaction> fruitTransactionStatistic
                = parseStatisticService.parse(dataFromFile);
        FruitTransactionService fruitTransactionService
                = new FruitTransactionServiceImpl(operationStrategy);
        fruitTransactionService.process(fruitTransactionStatistic);

        CreateReportService createReport = new CreateReportServiceImpl(fruitService);
        String report = createReport.createReport();
        ReportWriterService reportWriterService = new CsvReportWriterService();
        reportWriterService.writeReport(report, REPORT_PATH);
    }
}

