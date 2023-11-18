package core.basesyntax;

import core.basesyntax.data.processing.TransactionParser;
import core.basesyntax.data.processing.TransactionParserImpl;
import core.basesyntax.file.processing.CsvFileReader;
import core.basesyntax.file.processing.CsvFileReaderImpl;
import core.basesyntax.file.processing.CsvFileWriter;
import core.basesyntax.file.processing.CsvFileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.handlers.BalanceHandler;
import core.basesyntax.service.handlers.PurchaseHandler;
import core.basesyntax.service.handlers.ReturnHandler;
import core.basesyntax.service.handlers.SupplyHandler;
import core.basesyntax.service.implementations.ReportCreatorImpl;
import core.basesyntax.service.implementations.TransactionProcessorImpl;
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
        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        List<String> lines = csvFileReader.read(FILE_PATH + FILE_NAME_FROM);

        TransactionParser parser = new TransactionParserImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        List<FruitTransaction> transactions = parser.parseTransactions(lines);
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);

        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(strategy);
        transactionProcessor.process(transactions);

        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.create();

        CsvFileWriter writing = new CsvFileWriterImpl(FILE_PATH + FILE_NAME_TO);
        writing.writing(report);
    }
}
