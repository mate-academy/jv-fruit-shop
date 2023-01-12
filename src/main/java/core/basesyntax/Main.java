package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.ReadFileService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.WriteFileService;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReadFileServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriteFileServiceImpl;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final Path PATH_TO_INPUT_FILE = Path.of("src/main/resources/input.csv");
    private static final Path PATH_TO_REPORT_FILE = Path.of("src/main/resources/report.csv");
    private static final ReadFileService readFileService =
            new ReadFileServiceImpl();
    private static final FruitTransactionParser fruitTransactionParser =
            new FruitTransactionParserImpl();
    private static final TransactionProcessor transactionProcessor =
            new TransactionProcessorImpl();
    private static final ReportGenerator reportGenerator =
            new ReportGeneratorImpl();
    private static final WriteFileService writeFileService =
            new WriteFileServiceImpl();

    public static void main(String[] args) {
        List<String> dataFromFile = readFileService.readFromFile(PATH_TO_INPUT_FILE);
        List<FruitTransaction> fruitTransactions =
                fruitTransactionParser.toTransaction(dataFromFile);
        transactionProcessor.process(fruitTransactions);
        writeFileService.writeToFile(PATH_TO_REPORT_FILE, reportGenerator.generateReport());
    }
}
