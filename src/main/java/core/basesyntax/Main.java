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
import service.ReportService;
import service.TransactionParserService;
import serviceimpl.ReaderImpl;
import serviceimpl.ReportImpl;
import serviceimpl.TransactionParserImpl;
import serviceimpl.WriterImpl;
import strategy.StrategyChoosing;
import strategy.StrategyImpl;

public class Main {
    private static final File INPUT_FILE = new File("src/main/java/resources/input.csv");
    private static final File OUTPUT_FILE = new File("src/main/java/resources/output.csv");
    private static ReaderImpl reader = new ReaderImpl();
    private static WriterImpl writer = new WriterImpl();
    private static ReportService reporting = new ReportImpl();
    private static Map<FruitTransaction.Operation, OperationTypeHandler> strategy = new HashMap<>();
    private static StrategyChoosing strategyChoosing = new StrategyImpl(strategy);
    private static TransactionParserService parser = new TransactionParserImpl(strategyChoosing);

    public static void main(String[] args) {
        strategy.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        strategy.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        strategy.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        strategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());

        List<String> content = reader.read(INPUT_FILE);
        parser.saveToStorage(content);
        String report = reporting.newReport();
        writer.write(OUTPUT_FILE, report);
    }
}
