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
import core.basesyntax.strategy.BalanceOperationImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationImpl;
import core.basesyntax.strategy.ReturnOperationImpl;
import core.basesyntax.strategy.SupplyOperationImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_DATA_PATH = "src/main/java/resource/data.csv";
    private static final String OUTPUT_DATA_PATH = "src/main/java/resource/report.csv";
    private static final String BALANCE = "b";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put(BALANCE, new BalanceOperationImpl());
        map.put(PURCHASE, new PurchaseOperationImpl());
        map.put(RETURN, new ReturnOperationImpl());
        map.put(SUPPLY, new SupplyOperationImpl());

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
        writeToFile.writeToFile(OUTPUT_DATA_PATH,
                createReportService.createReport(Storage.storage));
    }

}
