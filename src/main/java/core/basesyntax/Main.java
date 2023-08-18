package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
    private static final String fromFileName = "src/main/resources/shop.csv";
    private static final String toFileName = "src/main/resources/report.csv";

    public static void main(String[] args) {
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);

        FileReader fileReader = new FileReaderImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl(strategy);
        ReportCreator reportCreator = new ReportCreatorImpl();
        FileWriter fileWriter = new FileWriterImpl();

        List<String> data = fileReader.readFromFile(fromFileName);
        List<FruitTransaction> transactions = transactionParser.parse(data);
        fruitShopService.process(transactions);
        String report = reportCreator.createReport();
        fileWriter.writeToFile(toFileName, report);
    }
}



