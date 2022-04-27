package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationService;
import core.basesyntax.service.operation.OperationServiceImpl;
import core.basesyntax.service.parse.ParserService;
import core.basesyntax.service.parse.ParserServiceImpl;
import core.basesyntax.service.read.ReaderService;
import core.basesyntax.service.read.ReaderServiceImpl;
import core.basesyntax.service.report.ReportService;
import core.basesyntax.service.report.ReportServiceImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.handlers.BalanceOperationHandler;
import core.basesyntax.service.strategy.handlers.OperationHandler;
import core.basesyntax.service.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.service.strategy.handlers.ReturnOperationHandler;
import core.basesyntax.service.strategy.handlers.SupplyOperationHandler;
import core.basesyntax.service.write.WriterService;
import core.basesyntax.service.write.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_DATA_PATH = "src/main/resources/input.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {

        new WriterServiceImpl().write(INPUT_DATA_PATH,"type,fruit,quantity\n"
                + "b,banana,18\n"
                + "b,apple,100\n"
                + "s,banana,14\n"
                + "p,banana,15\n"
                + "r,apple,10\n"
                + "p,apple,50\n"
                + "p,banana,5\n"
                + "s,banana,544");
        doTask(INPUT_DATA_PATH, REPORT_PATH);
    }

    private static void doTask(String fromFile, String toFile) {
        StorageDao storageDao = new StorageDaoImpl();
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler(storageDao));
        operationHandlerMap.put("p", new PurchaseOperationHandler(storageDao));
        operationHandlerMap.put("s", new SupplyOperationHandler(storageDao));
        operationHandlerMap.put("r", new ReturnOperationHandler(storageDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        OperationService operationService = new OperationServiceImpl(operationStrategy);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        List<String> data = readerService.readFile(fromFile);
        List<FruitTransaction> transactions = parserService.parse(data);
        operationService.process(transactions);
        String report = reportService.createReport(storageDao.getAll());
        writerService.write(toFile, report);
    }

}
