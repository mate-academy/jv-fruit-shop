package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReaderImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import core.basesyntax.service.TransactionProcessorImpl;
import core.basesyntax.service.Writer;
import core.basesyntax.service.WriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.Balance;
import core.basesyntax.strategy.impl.Purchase;
import core.basesyntax.strategy.impl.Return;
import core.basesyntax.strategy.impl.Supply;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT = "src/main/resources/input.csv";
    private static final String REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        List<String> products = reader.readFile(INPUT);

        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> transactions = parser.parse(products);

        OperationStrategy operationStrategy = new OperationStrategy(Map.of(
                Operation.BALANCE, new Balance(),
                Operation.SUPPLY, new Supply(),
                Operation.PURCHASE, new Purchase(),
                Operation.RETURN, new Return()));

        TransactionProcessorImpl processor = new
                TransactionProcessorImpl(operationStrategy);
        processor.process(transactions);

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();

        Writer writer = new WriterImpl();
        writer.writeReport(REPORT);
    }
}
