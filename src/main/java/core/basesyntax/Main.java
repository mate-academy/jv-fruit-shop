package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.IDataConverter;
import core.basesyntax.service.IFileReader;
import core.basesyntax.service.IFileWriter;
import core.basesyntax.service.IReportGenerator;
import core.basesyntax.service.impl.DataConverter;
import core.basesyntax.service.impl.FileReaderCsv;
import core.basesyntax.service.impl.FileWriter;
import core.basesyntax.service.impl.ReportGenerator;
import core.basesyntax.strategy.BalanceTransaction;
import core.basesyntax.strategy.ITransaction;
import core.basesyntax.strategy.PurchaseTransaction;
import core.basesyntax.strategy.ReturnTransaction;
import core.basesyntax.strategy.SupplyTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Read the file content
        IFileReader fileReader = new FileReaderCsv();
        String filePath = "src/main/resources/testInput";
        List<String> fileContent = fileReader.readFile(filePath);
        System.out.println(fileContent);

        // Convert the file content to a list of FruitTransaction objects
        IDataConverter dataConverter = new DataConverter();
        List<FruitTransaction> transactions =
                dataConverter.convertData(fileContent);
        System.out.println(transactions);

        // Create a Storage
        Storage storage = new Storage();

        // Create a map of strategies
        Map<FruitTransaction.OperationType, ITransaction> strategies = new HashMap<>();

        strategies.put(FruitTransaction.OperationType.BALANCE, new BalanceTransaction());
        strategies.put(FruitTransaction.OperationType.SUPPLY, new SupplyTransaction());
        strategies.put(FruitTransaction.OperationType.PURCHASE, new PurchaseTransaction());
        strategies.put(FruitTransaction.OperationType.RETURN, new ReturnTransaction());

        // Execute each transaction
        for (FruitTransaction transaction : transactions) {
            ITransaction strategy =
                    strategies.get(transaction.getOperation());

            if (strategy == null) {
                throw new IllegalArgumentException(
                        "No strategy for operation: "
                                + transaction.getOperation()
                );
            }

            strategy.execute(transaction, storage);
        }

        IReportGenerator reportGenerator = new ReportGenerator();
        String report = reportGenerator.generateReport(storage.getStorage());
        System.out.println(report);

        IFileWriter writer = new FileWriter();
        String reportFilePath = "src/main/resources/report.csv";
        writer.writeToFile(reportFilePath, report);

    }
}
