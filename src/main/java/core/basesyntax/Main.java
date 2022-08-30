package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.parsing.FileParserImpl;
import core.basesyntax.service.servise.Reader;
import core.basesyntax.service.servise.impl.ReaderImpl;
import core.basesyntax.service.servise.impl.ReportGeneratorImpl;
import core.basesyntax.service.servise.impl.WriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String RECORDS_FILE_NAME = "src/main/resources/records.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {

        Reader reader = new ReaderImpl();
        List<String> recordsFromFile = reader.read(RECORDS_FILE_NAME);
        List<FruitTransaction> transactions = new FileParserImpl()
                .parse(recordsFromFile);

        for (FruitTransaction transaction : transactions) {
            new OperationStrategy().operationStrategy(transaction);
        }

        String report = new ReportGeneratorImpl().report();
        new WriterImpl().createReportFile(report, REPORT_FILE_NAME);
    }
}
