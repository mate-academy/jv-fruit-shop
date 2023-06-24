package core.basesyntax;

import handlers.BalanceHandler;
import handlers.OperationTypeHandler;
import handlers.PurchaseHandler;
import handlers.ReturnHandler;
import handlers.SupplyHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ReaderService;
import service.ReportService;
import service.TransactionParserService;
import service.WriterService;
import serviceimpl.ReaderServiceImpl;
import serviceimpl.ReportServiceImpl;
import serviceimpl.TransactionParserServiceImpl;
import serviceimpl.WriterServiceImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final File INPUT_FILE = new File("src/main/java/resources/input.csv");
    private static final File OUTPUT_FILE = new File("src/main/java/resources/output.csv");
    private static final int FIRST_VALID_LINE = 1;
    private static ReaderService reader = new ReaderServiceImpl();
    private static WriterService writer = new WriterServiceImpl();

    private static ReportService reporting = new ReportServiceImpl();
    private static Map<FruitTransaction.Operation, OperationTypeHandler> strategy = new HashMap<>();
    private static OperationStrategy operationStrategy = new OperationStrategyImpl(strategy);
    private static TransactionParserService parser = new TransactionParserServiceImpl();

    public static void main(String[] args) {
        strategy.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        strategy.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        strategy.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        strategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());

        List<String> content = reader.read(INPUT_FILE);
        for (int i = FIRST_VALID_LINE; i < content.size(); i++) {
            FruitTransaction fruitTransaction = parser.saveToStorage(content.get(i));
            operationStrategy.getHandlerByOperation(fruitTransaction.getOperation())
                    .handle(fruitTransaction);
        }
        String report = reporting.newReport();
        writer.write(OUTPUT_FILE, report);
    }
}
