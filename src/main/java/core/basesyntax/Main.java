package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.impl.ConvertServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StoreServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.impl.service.ConvertService;
import core.basesyntax.service.impl.service.ReaderService;
import core.basesyntax.service.impl.service.ReportService;
import core.basesyntax.service.impl.service.WriterService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handlers.BalanceOperationHandler;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.strategy.handlers.ReturnOperationHandler;
import core.basesyntax.strategy.handlers.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlersMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlersMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlersMap.put(Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);

        ReaderService fileReader = new ReaderServiceImpl();
        List<String> rows = fileReader.readData("src/main/resources/validValues_ok.csv");

        ConvertService converter = new ConvertServiceImpl();
        List<FruitTransaction> fruitTransactionList = converter.convertData(rows);

        StoreServiceImpl storeService = new StoreServiceImpl(operationStrategy);
        storeService.putToMap(fruitTransactionList);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();

        WriterService fileWriter = new WriterServiceImpl();
        fileWriter.writeData(report, "src/main/resources/report.csv");
    }
}
