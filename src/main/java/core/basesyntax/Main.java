package core.basesyntax;

import core.basesyntax.impl.FileReaderImpl;
import core.basesyntax.impl.ParseTransactionServiceImpl;
import core.basesyntax.impl.ReportGeneratorImpl;
import core.basesyntax.impl.ReportWriterImpl;
import core.basesyntax.impl.TransactionServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.ParseTransactionService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.TransactionService;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/java/resources/input.csv";
    private static final String REPORT_FILE_NAME = "src/main/java/resources/report.csv";

    private static final FileReader fileReader = new FileReaderImpl();
    private static final ReportWriter reportWriter = new ReportWriterImpl();
    private static final ParseTransactionService parseTransactionService =
            new ParseTransactionServiceImpl();
    private static final ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private static final TransactionService transactionService = new TransactionServiceImpl();

    public static void main(String[] args) {
        List<String> dataFromFile = fileReader.read(INPUT_FILE_NAME);
        List<FruitTransaction> fruitTransactions =
                parseTransactionService.parseTransaction(dataFromFile);
        transactionService.executeTransaction(fruitTransactions);
        String report = reportGenerator.generateReport();
        reportWriter.writeToFile(report, REPORT_FILE_NAME);
    }
}
