package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReadFileService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.WriteFileService;
import core.basesyntax.service.impl.ReadFileServiceImpl;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;

import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final ReadFileService readFileService = new ReadFileServiceImpl();
    private static final FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
    private static final TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
    private static  ReportGenerator reportGenerator;
    private static WriteFileService writeFileService;
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    public static void main(String[] args) {
        String dataFromCsv = readFileService.readFromFile(Path.of(INPUT_FILE_PATH));
        List<FruitTransaction> transactions = fruitTransactionParser.parseTransactions(dataFromCsv);
        transactionProcessor.process(transactions);
        String report = reportGenerator.generateReport();

    }
}
