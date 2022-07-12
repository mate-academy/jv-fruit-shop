package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
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
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        String fromFilePath = "src/main/resources/input.csv";
        String toFilePath = "src/main/resources/report.csv";

        CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
        List<String[]> readData = readerService.readFromFile(fromFilePath);
        FruitDao fruitDao = new FruitDaoImpl();
        ParserService parserService = new ParserServiceImpl(fruitDao);
        List<FruitTransaction> fruitTransactions = parserService.parseData(readData);
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        ShopService service = new ShopServiceImpl(fruitDao, strategy);
        service.process(fruitTransactions);
        ReportService reportService = new ReportServiceImpl();
        CsvFileWriterService writerService = new CsvFileWriterServiceImpl();
        List<Fruit> fruits = fruitDao.getAll();
        String report = reportService.makeReport(fruits);
        writerService.writeToFile(report, toFilePath);
    }
}
