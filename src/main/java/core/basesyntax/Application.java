package core.basesyntax;

import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.ReportGenerationService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.QuantityCalculatorServiceImpl;
import core.basesyntax.service.impl.ReportGenerationServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationHandlerStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import core.basesyntax.transaction.FruitTransaction;
import core.basesyntax.transaction.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String VALID_READ_FROM_FILE = "src/main/resources/DatabaseOfShop.csv";
    private static final String WRITE_TO_FILE = "src/main/resources/ResultDB.csv";

    public static void main(String[] args) {
        List<String> linesFromFile = new CsvFileReaderServiceImpl()
                .readFromFile(VALID_READ_FROM_FILE);

        Map<Operation, OperationHandler> strategies = new HashMap<>();
        strategies.put(Operation.BALANCE, new BalanceOperationHandler());
        strategies.put(Operation.PURCHASE, new PurchaseOperationHandler());
        strategies.put(Operation.RETURN, new ReturnOperationHandler());
        strategies.put(Operation.SUPPLY, new SupplyOperationHandler());

        OperationHandlerStrategy operationHandlerStrategy =
                new OperationHandlerStrategyImpl(strategies);

        List<FruitTransaction> fruitTransactions = new TransactionParserServiceImpl()
                .parse(linesFromFile);

        QuantityCalculatorServiceImpl quantityCalculatorService =
                new QuantityCalculatorServiceImpl(operationHandlerStrategy);
        quantityCalculatorService.calculate(fruitTransactions);

        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        ReportGenerationService reportGenerationService = new ReportGenerationServiceImpl();
        csvFileWriterService.writeToFile(WRITE_TO_FILE, reportGenerationService.generateReport());
    }
}
