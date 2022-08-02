package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ScvParseServiceImpl;
import core.basesyntax.service.impl.ScvReportServiceImpl;
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
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitDao));

        String fromFilePath = "src/main/resources/file.csv";
        FileReaderService readerService = new FileReaderServiceImpl();
        List<String> fileContent = readerService.readFromFile(fromFilePath);

        ParserService parserService = new ScvParseServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parse(fileContent);

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService shopService = new FruitShopServiceImpl(strategy);
        shopService.process(fruitTransactions);

        ReportService reportService = new ScvReportServiceImpl();
        Map<String, Integer> info = shopService.getAll();
        String report = reportService.getReport(info);

        String toFilePath = "src/main/resources/report.csv";
        FileWriterService writerService = new FileWriterServiceImpl();
        writerService.writeToFile(report, toFilePath);
    }
}
