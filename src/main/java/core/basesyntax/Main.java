package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.db.model.FruitTransaction;
import core.basesyntax.db.service.ReportCreatorService;
import core.basesyntax.db.service.FileReaderService;
import core.basesyntax.db.service.FileWriterService;
import core.basesyntax.db.service.FileParserService;
import core.basesyntax.db.strategy.OperationHandler;
import core.basesyntax.db.strategy.OperationStrategy;
import core.basesyntax.db.strategy.handler.impl.BalanceOperationHandler;
import core.basesyntax.db.strategy.handler.impl.PurchaseOperationHandler;
import core.basesyntax.db.strategy.handler.impl.ReturnOperationHandler;
import core.basesyntax.db.strategy.handler.impl.SupplyOperationHandler;
import core.basesyntax.db.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.db.service.impl.FileReaderServiceImpl;
import core.basesyntax.db.service.impl.FileWriterServiceImpl;
import core.basesyntax.db.service.impl.FileParserServiceImpl;
import core.basesyntax.db.strategy.handler.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderService service = new FileReaderServiceImpl();
        List<String> strings = service.readFromFile("src/main/data/input.csv");
        FileParserService fruitParserService = new FileParserServiceImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        List<FruitTransaction> fruitTransactionList = fruitParserService.parse(strings);
        for (FruitTransaction fruitTransaction: fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation().getOperationByChar());
            operationHandler.apply(fruitTransaction);
        }
        Map<String, Integer> map = Storage.getStorage();
        ReportCreatorService createReport = new ReportCreatorServiceImpl();
        String report = createReport.getReport(map);
        FileWriterService reportFile = new FileWriterServiceImpl();
        reportFile.writeToFile(report, "src/main/data/report.csv");
    }
}

