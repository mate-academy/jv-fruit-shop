package core.basesyntax;

import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.CsvReportServiceImpl;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.TransactionProcessorImpl;
import core.basesyntax.service.TransitionConvertorImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String PIVOT_FILE_NAME = "src/main/resources/pivot.csv";
    private static final String BALANCE_FILE_NAME = "src/main/resources/database.csv";

    public static void main(String[] args) {
        TransactionProcessor transactionProcessor =
                new TransactionProcessorImpl(new OperationStrategyImpl());
        List<String> stringsFromFile = new FileReaderImpl().readFromFile(BALANCE_FILE_NAME);
        List<Transaction> transactionsFromFile = new TransitionConvertorImpl()
                .convert(stringsFromFile);
        transactionProcessor.process(transactionsFromFile);
        String report = new CsvReportServiceImpl().makeReport();
        new FileWriterImpl().writeToFile(PIVOT_FILE_NAME, report);
    }
}
