package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operations.BalanceOperation;
import core.basesyntax.strategy.operations.PurchaseOperation;
import core.basesyntax.strategy.operations.ReturnOperation;
import core.basesyntax.strategy.operations.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    private static final String INPUT_DATA_PATH
            = "src/main/java/resources/fileFrom.csv";
    private static final String OUTPUT_DATA_PATH
            = "src/main/java/resources/report.csv";
    private static final String BALANCE = "b";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";

    public static void main(String[] args) {
        Map<String, OperationStrategy> commands = new HashMap<>();
        commands.put(BALANCE, new BalanceOperation());
        commands.put(PURCHASE, new PurchaseOperation());
        commands.put(SUPPLY, new SupplyOperation());
        commands.put(RETURN, new ReturnOperation());

        OperationStrategyImpl strategy = new OperationStrategyImpl(commands);

        FileReaderServiceImpl fileReaderService = new FileReaderServiceImpl();
        List<String> lines = fileReaderService.read(INPUT_DATA_PATH);

        //parse data
        ParserServiceImpl parser = new ParserServiceImpl();
        List<Transaction> transactions = parser.parse(lines);

        //send commands
        for (Transaction transaction : transactions) {
            OperationStrategy operation =
                    strategy.getByOperation(transaction.getOperation());
            operation.apply(transaction);
        }
        //crete report
        ReportService reportService = new ReportServiceImpl();
        //write to file
        FileWriterServiceImpl fileWriterServiceimpl = new FileWriterServiceImpl();
        fileWriterServiceimpl.write(reportService.getReport(Storage.storageDate), OUTPUT_DATA_PATH);
    }
}
