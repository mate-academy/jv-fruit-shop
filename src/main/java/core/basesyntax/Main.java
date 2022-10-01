package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.OperationStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(final String[] args) {
        String transactionsPath = "src/main/resources/transactions.csv";
        String reportPath = "src/main/resources/report.csv";
        Map<Operation, OperationStrategy> operations = new HashMap<>();

        ReaderService reader = new CsvFileReaderService();
        WriterService writer = new CsvFileWriterService();
        FruitService fruitService = new FruitServiceImpl(operations);

        List<FruitTransaction> transactions = reader.readFromFile(transactionsPath);
        String report = fruitService.generateReport(transactions);
        writer.writeToFile(report,reportPath);


    }
}
