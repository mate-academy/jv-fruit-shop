import core.basesyntax.db.Storage;
import core.basesyntax.model.CsvTransactionParser;
import core.basesyntax.model.FruitServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.TransactionParser;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileReaderResult;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.strategy.BalanceOperationStrategy;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.PurchaseOperationStrategy;
import core.basesyntax.service.strategy.ReturnOperationStrategy;
import core.basesyntax.service.strategy.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String inputFileName = "src/main/resources/input_file.csv";
        String outputFileName = "src/main/resources/output_file.csv";
        Storage storage = new Storage();
        Map<String, OperationStrategy> operationStrategies
                = createOperationStrategies(storage);
        FruitServiceImpl fruitService = new FruitServiceImpl(operationStrategies);
        ReportCreator reportCreator = new ReportCreatorImpl();
        FileWriterService fileWriterService = new FileWriterImpl();
        FileReaderService fileReaderService = new FileReaderImpl();
        TransactionParser transactionParser = new CsvTransactionParser();
        FileReaderResult fileReaderResult = fileReaderService.readFile(inputFileName);
        FruitTransaction[] transactions = transactionParser
                .parseTransaction(fileReaderResult.getLines());
        fruitService.processFruitTransactions(transactions);
        Map<String, Integer> fruitReport = storage.getInventory();
        String report = reportCreator.createReport(fruitReport);
        fileWriterService.writeReportToFile(report, outputFileName);
        System.out.println("Report generated successfully");
    }

    public static Map<String, OperationStrategy> createOperationStrategies(Storage storage) {
        Map<String, OperationStrategy> operationStrategies = new HashMap<>();
        operationStrategies.put("b", new BalanceOperationStrategy(storage));
        operationStrategies.put("s", new SupplyOperationStrategy(storage));
        operationStrategies.put("p", new PurchaseOperationStrategy(storage));
        operationStrategies.put("r", new ReturnOperationStrategy(storage));
        return operationStrategies;
    }
}
