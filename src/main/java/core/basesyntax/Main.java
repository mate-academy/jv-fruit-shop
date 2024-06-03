package core.basesyntax;

import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReaderImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.Writer;
import core.basesyntax.service.WriterImpl;
import core.basesyntax.strategy.Transaction;

public class Main {
    private static final String INPUT = "src/main/resources/input.csv";
    private static final String REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Reader reader = new ReaderImpl(INPUT);
        ReportCreator reportCreator = new ReportCreatorImpl();
        Parser parser = new ParserImpl();
        Writer writer = new WriterImpl(REPORT);
        Transaction transaction = new Transaction();
    }
}
