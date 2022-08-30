package core.basesyntax;

import core.basesyntax.model.Transaktion;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String BALANCE = "b";
    public static final String SUPPLY = "s";
    public static final String RETURN = "r";
    public static final String PURCHASE = "p";
    public static final String INPUT_FILE = "src/main/resources/Input.csv";
    public static final String OUTPUT_FILE = "src/main/resources/Output.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operations = new HashMap<>();
        operations.put(BALANCE, new BalanceOperationHandler());
        operations.put(PURCHASE, new PurchaseOperationHandler());
        operations.put(RETURN, new ReturnOperationHandler());
        operations.put(SUPPLY, new SupplyOperationStrategy());

        OperationStrategy strategy = new OperationStrategy(operations);

        ReaderService readerService = new ReaderServiceImpl();
        List<String> lines = readerService.readFromFile(INPUT_FILE);

        List<Transaktion> transaktions = new ParserImpl().parse(lines);

        for (Transaktion transaktion : transaktions) {
            OperationHandler handler = strategy.getByOperation(transaktion.getOperation());
            handler.apply(transaktion);
        }

        String report = new ReportServiceImpl().getReport();

        new WriterServiceImpl().writeToFile(report, OUTPUT_FILE);
    }
}
