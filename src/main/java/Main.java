import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.PrecessDataService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriterServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.PrecessDataServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseHandler;
import core.basesyntax.strategy.handler.ReturnHandler;
import core.basesyntax.strategy.handler.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReaderService readerService = new CsvReaderServiceImpl();
        WriterService writerService = new CsvWriterServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(getOperationHandlerMap());
        PrecessDataService precessDataService = new PrecessDataServiceImpl(operationStrategy);
        FruitDao fruitDao = new FruitDaoImpl();

        List<String> lines = readerService.getLines("src/main/resources/text.csv");
        List<FruitTransaction> records = parserService.getTransactions(lines);
        precessDataService.writeToStorage(records);
        String report = reportService.generateReport(fruitDao.getAll());
        writerService.write("src/main/resources/result.csv", report);
    }

    private static Map<FruitTransaction.Operation, OperationHandler> getOperationHandlerMap() {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        return operationHandlerMap;
    }
}
