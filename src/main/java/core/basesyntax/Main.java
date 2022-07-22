package core.basesyntax;

import core.basesyntax.dao.FileReaderCsvImpl;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReportServiceImpl;
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
        //1 Read data from CSV file
        List<String> stringsFromFile = new FileReaderCsvImpl().readFromFile(BALANCE_FILE_NAME);
        List<Transaction> transactionsFromFile = new TransitionConvertorImpl()
                                                        .convert(stringsFromFile);

        //2 Process this data
        transactionProcessor.process(transactionsFromFile);

        //3 Generate a report on processed data
        String report = new ReportServiceImpl().makeReport();

        //4 Write report to new file
        new FileWriterImpl().writeToFile(PIVOT_FILE_NAME, report);
    }
}
