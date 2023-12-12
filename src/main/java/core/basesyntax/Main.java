package core.basesyntax;

import core.basesyntax.context.OperationContext;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvParserService;
import core.basesyntax.service.impl.CsvReaderService;
import core.basesyntax.service.impl.CsvWriterService;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String inputFilePath = "C:\\Users\\Kali\\IdeaProjects\\"
                + "jv-fruit-shop\\src\\main\\resources\\input.csv";

        ReaderService readerService = new CsvReaderService();
        List<String> lines = readerService.readFromFile(inputFilePath);
        ParserService parserService = new CsvParserService();
        List<FruitTransaction> transactions = parserService.parseCsv(lines);

        FruitStorage fruitStorage = new FruitStorage();
        Map<String, Integer> report = fruitStorage.getFruitInventory();

        System.out.println("Report before processing transactions: " + report);

        OperationContext operationContext = new OperationContext(fruitStorage);
        for (FruitTransaction transaction : transactions) {
            if (transaction != null) {
                operationContext.getOperation(transaction.getOperation())
                        .performOperation(transaction, fruitStorage);
            }
        }

        final String outputFilePath = "C:\\Users\\Kali\\IdeaProjects\\"
                + "jv-fruit-shop\\src\\main\\resources\\output.csv";

        report = fruitStorage.getFruitInventory();
        System.out.println("Report after processing transactions: " + report);

        WriterService writerService = new CsvWriterService();
        writerService.writeReportToCsv(report, outputFilePath);

    }
}
