package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.parser.TextLineParser;
import core.basesyntax.parser.impl.CsvTextLineParser;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FRUITS_CSV_FILEPATH = "src/main/resources/fruits.csv";
    private static final String SEPARATOR = ",";
    private static final String REPORT_CSV_FILEPATH = "src/main/resources/report.csv";
    private static final String CSV_OUTPUT_HEADER = "fruit,quantity";
    private static final int HEADER_INDEX = 0;

    public static void main(String[] args) {
        List<String> fileContents = new ReaderServiceImpl().readFromFile(FRUITS_CSV_FILEPATH);
        TextLineParser lineParser = new CsvTextLineParser();
        FruitStorage storage = new FruitStorage();
        TransactionStrategy strategy = new TransactionStrategyImpl(storage);

        fileContents.remove(HEADER_INDEX);
        for (String line : fileContents) {
            FruitTransaction transaction = lineParser.extractOperationType(line);
            if (transaction != null) {
                TransactionHandler transactionHandler = strategy.get(transaction.getOperation());
                transactionHandler.process(transaction);
            }
        }

        List<String> reportList = new ArrayList<>();
        reportList.add(CSV_OUTPUT_HEADER);
        storage.getStorage().forEach((key, value) -> reportList.add(key + SEPARATOR + value));
        new WriterServiceImpl().writeToFile(reportList, REPORT_CSV_FILEPATH);
    }
}
