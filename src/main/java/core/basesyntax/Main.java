package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.impl.BalanceHandler;
import core.basesyntax.strategy.handler.impl.OperationStrategyImpl;
import core.basesyntax.strategy.handler.impl.PurchaseHandler;
import core.basesyntax.strategy.handler.impl.ReturnHandler;
import core.basesyntax.strategy.handler.impl.SupplyHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReadService csvFileReader = new ReadServiceImpl();
        ParseService fruitTransactionParser = new ParseServiceImpl();
        OperationStrategy operationStrategy = createOperationStrategy();
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        ReportService reportService = new ReportServiceImpl();
        WriteService csvFileWriter = new WriteServiceImpl();

        List<String> stringFromFile = csvFileReader.readFromFile(PATH_TO_INPUT_FILE);
        List<FruitTransaction> fruitTransactions = fruitTransactionParser.parse(stringFromFile);
        fruitShopService.processData(fruitTransactions);
        String report = reportService.generateReport();
        csvFileWriter.writeToFile(PATH_TO_REPORT_FILE, report);
    }

    private static OperationStrategy createOperationStrategy() {
        Map<Operation, OperationHandler> operationHandlerMap =
                Map.of(Operation.BALANCE, new BalanceHandler(),
                        Operation.SUPPLY, new SupplyHandler(),
                        Operation.PURCHASE, new PurchaseHandler(),
                        Operation.RETURN, new ReturnHandler());

        return new OperationStrategyImpl(operationHandlerMap);
    }
}
