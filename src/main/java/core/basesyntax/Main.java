package core.basesyntax;

import core.basesyntax.models.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.service.impl.TransactionsCalculatorImpl;
import java.util.List;

public class Main {
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
