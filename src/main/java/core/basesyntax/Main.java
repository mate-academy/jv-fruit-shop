package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        FruitDao fruitDao = new FruitDaoImpl();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitDao));

        String fromFilePath = "src/main/resources/input.csv";
        String toFilePath = "src/main/resources/report.csv";

        FileReaderService readerService = new CsvFileReaderServiceImpl();
        List<String[]> readData = readerService.readFromFile(fromFilePath);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parseData(readData);

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        ShopService service = new ShopServiceImpl(strategy);
        service.process(fruitTransactions);

        ReportService reportService = new ReportServiceImpl(fruitDao);
        String report = reportService.makeReport();

        FileWriterService writerService = new CsvFileWriterServiceImpl();
        writerService.writeToFile(report, toFilePath);
    }
}
