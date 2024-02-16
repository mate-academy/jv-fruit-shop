package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.ParseTransactionService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.ParseTransactionServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    private static FileReader fileReader =
            new FileReaderImpl();
    private static FruitStorage fruitStorage =
            new FruitStorage();
    private static ReportWriter reportWriter =
            new ReportWriterImpl();
    private static ParseTransactionService parseTransactionService =
            new ParseTransactionServiceImpl();
    private static ReportCreator reportCreator =
            new ReportCreatorImpl();
    private static TransactionService transactionService =
            new TransactionServiceImpl();

    public static void main(String[] args) {
        List<String> dataFromFile = fileReader.read(INPUT_FILE_NAME);
        List<FruitTransaction> fruitTransactions =
                parseTransactionService.parseTransactions(dataFromFile);
        transactionService.executeTransactions(fruitTransactions);
        String report = reportCreator.createReport();
        reportWriter.writeToFile(report, REPORT_FILE_NAME);
    }

    public static FruitStorage getFruitStorage() {
        return fruitStorage;
    }
}
