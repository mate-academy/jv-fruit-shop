package core.basesyntax;

import core.basesyntax.models.Transaction;
import core.basesyntax.parse.Parser;
import core.basesyntax.parse.ParserImpl;
import core.basesyntax.reader.FileReader;
import core.basesyntax.reader.FileReaderImpl;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.strategy.TransactionsCalculatorImpl;
import core.basesyntax.writer.ReportWriter;
import core.basesyntax.writer.ReportWriterImpl;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    private static final String PATH_FROM = "src/main/resources/inputData.csv";
    private static final String PATH_TO = "src/main/resources/outputData.csv";

    public static void main(String[] args) {
        // Read
        FileReader reader = new FileReaderImpl();
        List<String> list = reader.read(PATH_FROM);

        // Parse to transaction
        Parser parse = new ParserImpl();
        List<Transaction> transactionList = parse.parse(list);

        // Adding to storage
        TransactionsCalculatorImpl handle = new TransactionsCalculatorImpl();
        handle.handleTransactions(transactionList);

        // Generating report
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generateReport();

        // Writing report to a file
        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeReport(report, PATH_TO);
    }

}
