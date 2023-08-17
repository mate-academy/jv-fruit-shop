package core.basesyntax;

import core.basesyntax.data.TransactionParser;
import core.basesyntax.data.TransactionParserImpl;
import core.basesyntax.files.FilesReader;
import core.basesyntax.files.FilesReaderImpl;
import core.basesyntax.files.FilesWriter;
import core.basesyntax.files.FilesWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.handles.BallanceHandler;
import core.basesyntax.service.handles.PurchaseHandler;
import core.basesyntax.service.handles.ReturnHandler;
import core.basesyntax.service.handles.SupplyHandler;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String FILE_PATH = "src/main/resources/";
    public static final String FILE_NAME_FROM = "database.csv";
    public static final String FILE_NAME_TO = "report.csv";

    public static void main(String[] args) {
        FilesReader filesReader = new FilesReaderImpl();
        List<String> lines = filesReader.read(FILE_PATH + FILE_NAME_FROM);

        TransactionParser parser = new TransactionParserImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BallanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        List<FruitTransaction> transactions = parser.parseTransactions(lines);
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);

        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(strategy);
        transactionProcessor.process(transactions);

        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.create();

        FilesWriter writing = new FilesWriterImpl();
        writing.writeToFile(FILE_PATH + FILE_NAME_TO,report);
    }
}
