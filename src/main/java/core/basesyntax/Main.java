package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitTransform;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.impl.BalanceOperationHandler;
import core.basesyntax.service.handler.impl.PurchaseOperationHandler;
import core.basesyntax.service.handler.impl.ReturnOperationHandler;
import core.basesyntax.service.handler.impl.SupplyOperationHandler;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.FruitTransformImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String READ_FILE_PATH = "src/main/resources/data.csv";
    private static final String WRITE_FILE_PATH = "src/main/resources/report.csv";

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
        List<String> list = readerService.readFromFile(READ_FILE_PATH);
        FruitTransform fruitTransform = new FruitTransformImpl();
        List<FruitTransaction> fruitTransactions = fruitTransform.transform(list);
        FruitShopService fruitShopService = new FruitShopServiceImpl(strategy);
        fruitShopService.calculate(fruitTransactions);
        CreateReportService reportService = new CreateReportServiceImpl();
        List<String> reportList = reportService.createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(WRITE_FILE_PATH,reportList);
    }
}
