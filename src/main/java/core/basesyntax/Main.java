package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReaderImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import core.basesyntax.service.Writer;
import core.basesyntax.service.WriterImpl;
import core.basesyntax.strategy.TransactionProcessor;
import java.util.List;

public class Main {
    private static final String INPUT = "src/main/resources/input.csv";
    private static final String REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        List<String> products = reader.readFile(INPUT);
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();
        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> dates = parser.parse(products);
        TransactionProcessor transaction = new TransactionProcessor();
        for (var data : dates) {
            transaction.process(data);
        }
        Writer writer = new WriterImpl();
        writer.writeReport(REPORT);
    }
}
