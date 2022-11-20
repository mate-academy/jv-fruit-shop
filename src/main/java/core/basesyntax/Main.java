package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWrite;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriteImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader service = new FileReaderImpl();
        List<String> strings = service.readInputFile("src/main/resources/input_file.csv");
        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceHandler());
        operationHandlerMap.put("s", new SupplyHandler());
        operationHandlerMap.put("r", new ReturnHandler());
        operationHandlerMap.put("p", new PurchaseHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        List<FruitTransaction> fruitTransactionList = fruitTransactionParser.parse(strings);
        for (FruitTransaction fruitTransaction: fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation().getOperationString());
            operationHandler.apply(fruitTransaction);
        }
        Map<String, Integer> map = Storage.getStorageMap();
        ReportCreator createReport = new ReportCreatorImpl();
        String report = createReport.createReport(map);
        FileWrite reportFile = new FileWriteImpl();
        reportFile.writeToFile(report, "src/main/resources/report_file.csv");
    }
}
