package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReadFileService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.WriteFileService;
import core.basesyntax.service.impl.ReadFileServiceImpl;
import core.basesyntax.strategy.FruitTransactionParser;
import core.basesyntax.strategy.TransactionProcessor;
import core.basesyntax.strategy.impl.FruitTransactionParserImpl;
import core.basesyntax.strategy.impl.TransactionProcessorImpl;

import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final ReadFileService readFileService = new ReadFileServiceImpl();
    private static final FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
    private static final TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
    private static  ReportGenerator reportGenerator;
    private static WriteFileService writeFileService;
    private static final String PATH_TO_FILE = "src/main/resources/input.csv";
    public static void main(String[] args) {
        String dataFromCsv = readFileService.readFromFile(Path.of(PATH_TO_FILE));
        List<FruitTransaction> transactions = fruitTransactionParser.parseTransactions(dataFromCsv);
        transactionProcessor.process(transactions);
        String report = reportGenerator.generateReport();
    }
}
