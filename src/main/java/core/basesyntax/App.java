package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operations.BalanceOperationHandler;
import core.basesyntax.strategy.operations.PurchaseOperationHandler;
import core.basesyntax.strategy.operations.ReturnOperationHandler;
import core.basesyntax.strategy.operations.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    private static final String INPUT_DATA_PATH
            = "src/main/resources/fileFrom.csv";
    private static final String OUTPUT_DATA_PATH
            = "src/main/resources/report.csv";
    private static final String BALANCE = "b";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";

    public static void main(String[] args) {
        Map<String, OperationHandler> commands = new HashMap<>();
        commands.put(BALANCE, new BalanceOperationHandler());
        commands.put(PURCHASE, new PurchaseOperationHandler());
        commands.put(SUPPLY, new SupplyOperationHandler());
        commands.put(RETURN, new ReturnOperationHandler());

        OperationStrategy strategy = new OperationStrategy(commands);

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> lines = fileReaderService.read(INPUT_DATA_PATH);

        //parse data
        ParserService parser = new ParserServiceImpl();
        List<Transaction> transactions = parser.parse(lines);

        //send commands
        for (Transaction transaction : transactions) {
            OperationHandler operation =
                    strategy.getByOperation(transaction.getOperation());
            operation.apply(transaction);
        }
        //crete report
        ReportService reportService = new ReportServiceImpl();
        //write to file
        FileWriterService fileWriterServiceimpl = new FileWriterServiceImpl();
        fileWriterServiceimpl.write(reportService.getReport(), OUTPUT_DATA_PATH);
    }
}
