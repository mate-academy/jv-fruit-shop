package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReadFromFile;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import core.basesyntax.strategy.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_DATA_PATH = "src/main/java/resource/data.csv";
    private static final String OUTPUT_DATA_PATH = "src/main/java/resource/report.csv";
    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperationImpl());
        map.put("p", new PurchaseOperationImpl());
        map.put("r", new ReturnOperationImpl());
        map.put("s", new SupplyOperationImpl());

        OperationStrategy strategy = new OperationStrategy(map);

        ReadFromFile readFromFile = new ReadFromFileImpl();
        List<String> lines = readFromFile.readFromFile(INPUT_DATA_PATH);

        ParseService parseService = new ParseServiceImpl();
        List<Transaction> transactions = parseService.transactionsParser(lines);

        for (Transaction transaction : transactions) {
                OperationHandler operationHandler = strategy.getByOperation(transaction.getOperation());
                operationHandler.apply(transaction);
        }
        WriteToFileImpl writeToFile = new WriteToFileImpl();
        CreateReportService createReportService = new CreateReportServiceImpl();
        writeToFile.writeToFile(OUTPUT_DATA_PATH, createReportService.createReport(Storage.storage));
    }

}
