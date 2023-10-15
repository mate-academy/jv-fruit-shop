package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionExecutor;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionExecutorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/FruitTransaction.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/FruitReport.csv";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        List<String> inputRowsList = fileService.readFromFile(INPUT_FILE_PATH);
        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> transactionList = parser.parseTransactions(inputRowsList);
        Storage storage = new Storage();
        TransactionExecutor transactionExecutor = new TransactionExecutorImpl(storage);
        transactionExecutor.executeTransaction(transactionList);
        ReportService reporter = new ReportServiceImpl(storage);
        String report = reporter.createReport();
        fileService.writeToFile(REPORT_FILE_PATH, report);
    }
}
