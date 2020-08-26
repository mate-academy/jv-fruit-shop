package core.basesyntax;

import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.TransactionLogService;
import core.basesyntax.service.UpdateFruitStorageService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/fruit_transactions.csv";
        FileReaderService reader = new CsvFileReaderService();
        FileWriterService writer = new CsvFileWriterService();
        List<String[]> lines = reader.getTransactions(filePath);
        TransactionLogService transactionParserStrategy =
                new TransactionLogService();
        List<AbstractTransaction> transactions =
                transactionParserStrategy.logTransactions(lines);
        UpdateFruitStorageService updateService =
                new UpdateFruitStorageService();
        updateService.updateStock(transactions);
        writer.writeToFile(filePath, FruitStorage.getFruits());
    }
}
