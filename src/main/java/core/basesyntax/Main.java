package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConverterDataService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ConverterDataServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.impl.BalanceOperationHandler;
import core.basesyntax.strategy.handler.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.impl.ReturnOperationHandler;
import core.basesyntax.strategy.handler.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private static final String CAPTION = "fruit,quantity";
    private static final String SEPARATOR = ",";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        ReaderService readerService = new ReaderServiceImpl();
        ConverterDataService converterDataService = new ConverterDataServiceImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl(strategy);
        ReportService reportService = new ReportServiceImpl(CAPTION, SEPARATOR);
        WriterService writerService = new WriterServiceImpl();

        List<String> list = readerService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions =
                converterDataService.convertForTransaction(list);
        fruitShopService.processData(fruitTransactions);
        List<String> reportList = reportService.generateReport();
        writerService.writeDataToFile(REPORT_FILE_PATH, reportList);
    }
}
