package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionMapper;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionMapperImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.strategy.BalanceOperation;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.PurchaseOperation;
import core.basesyntax.service.strategy.ReturnOperation;
import core.basesyntax.service.strategy.SupplyOperation;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE = "src/main/resources/source.csv";
    private static final String DESTINATION = "src/main/resources/destination.csv";
    private static final Map<Transaction.Operation, OperationStrategy> HANDLERS = new HashMap<>();

    static {
        HANDLERS.put(Transaction.Operation.BALANCE, new BalanceOperation());
        HANDLERS.put(Transaction.Operation.SUPPLY, new SupplyOperation());
        HANDLERS.put(Transaction.Operation.PURCHASE, new PurchaseOperation());
        HANDLERS.put(Transaction.Operation.RETURN, new ReturnOperation());
    }

    public static void main(String[] args) {
        // read data from csv file
        Path source = Paths.get(SOURCE);
        FileReader reader = new CsvFileReader(source);
        List<String> lines = reader.read();
        // mapping data to Object
        TransactionMapper mapper = new TransactionMapperImpl();
        List<Transaction> transactions = mapper.mapAll(lines);

        // process transaction
        TransactionProcessor processor = new TransactionProcessorImpl(HANDLERS);
        transactions.forEach(processor::process);

        // create report
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.create();

        // write report to file
        Path destination = Paths.get(DESTINATION);
        FileWriter fileWriter = new CsvFileWriter(destination);
        fileWriter.write(report);
    }
}
