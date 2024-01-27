package core.basesyntax.fruitshop;

import core.basesyntax.fruitshop.model.FruitTransaction;
import core.basesyntax.fruitshop.service.DataProcessingService;
import core.basesyntax.fruitshop.service.FileReaderService;
import core.basesyntax.fruitshop.service.FileWriterService;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "src/main/resources/input.csv";
        String outputFilePath = "src/main/resources/output.csv";

        FileReaderService fileReaderService = new FileReaderService();
        DataProcessingService dataProcessingService = new DataProcessingService();
        FileWriterService reportService = new FileWriterService();

        List<FruitTransaction> transactions = fileReaderService
                .readTransactionsFromFile(inputFilePath);
        Map<String, Integer> fruitInventory = dataProcessingService
                .processTransactions(transactions);
        reportService.writeReportToFile(fruitInventory, outputFilePath);
    }
}
