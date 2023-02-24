package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";

    public static void main(String[] args) {
        FruitTransactionService transactionService
                = new FruitTransactionServiceImpl();

        ReaderService readerService = new ReaderServiceImpl();
        String readData = readerService.readFromFile(INPUT_FILE_PATH);
        TransactionParserService transactionParserService
                = new TransactionParserServiceImpl();
        List<FruitTransaction> transactions = transactionParserService.parseTransactions(readData);
        transactionService.processTransactions(transactions);

        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        String report = reportGeneratorService.generateReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeTextToFile(report, OUTPUT_FILE_PATH);
    }
}
