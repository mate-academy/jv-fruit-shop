package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.BalanceOperationStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationStrategy;
import core.basesyntax.strategy.ReturnOperationStrategy;
import core.basesyntax.strategy.SupplyOperationStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(final String[] args) {
        final String transactionsPath = "src/main/resources/transactions.csv";
        final String reportPath = "src/main/resources/report.csv";
        Map<Operation, OperationStrategy> operations = new HashMap<>();
        operations.put(Operation.PURCHASE, new PurchaseOperationStrategy());
        operations.put(Operation.BALANCE, new BalanceOperationStrategy());
        operations.put(Operation.RETURN, new ReturnOperationStrategy());
        operations.put(Operation.SUPPLY, new SupplyOperationStrategy());

        ReaderService reader = new CsvFileReaderService();
        WriterService writer = new CsvFileWriterService();
        FruitService fruitService = new FruitServiceImpl(operations);

        List<FruitTransaction> transactions = reader.readFromFile(transactionsPath);
        String report = fruitService.generateReport(transactions);
        writer.writeToFile(report, reportPath);

        File reportFile = new File(reportPath);
        try (
                FileReader fileReader = new FileReader(reportFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("File " + e + " not found.");
        }
    }
}
