package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
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
    private static final Map<FruitTransaction.Operation, OperationHandler> OPERATION_HANDLER_MAP =
            Map.of(FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                    FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
                    FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                    FruitTransaction.Operation.RETURN, new ReturnHandler());

    public static void main(String[] args) {
        ReadService csvFileReader = new ReadServiceImpl();
        ParseService fruitTransactionParser = new ParseServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(OPERATION_HANDLER_MAP);
        FruitShopService fruitShopService =
                new FruitShopServiceImpl(operationStrategy);
        ReportService reportService = new ReportServiceImpl();
        WriteService csvFileWriter = new WriteServiceImpl();
        List<String> stringFromFile = csvFileReader.readFromFile(PATH_TO_INPUT_FILE);
        List<FruitTransaction> fruitTransactions = fruitTransactionParser.parse(stringFromFile);
        fruitShopService.processData(fruitTransactions);
        String report = reportService.generateReport();
        csvFileWriter.writeToFile(PATH_TO_REPORT_FILE, report);
    }
}
