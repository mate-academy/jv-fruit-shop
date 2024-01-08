package core.basesyntax.services;

import core.basesyntax.db.Storage;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.fileprocessing.DataSplitter;
import core.basesyntax.services.fileprocessing.FileWriter;
import core.basesyntax.services.fileprocessing.Reader;
import core.basesyntax.services.fileprocessing.ReportGenerator;
import core.basesyntax.services.fileprocessing.TransactionGetter;
import core.basesyntax.services.fileprocessing.impl.DataSplitterImpl;
import core.basesyntax.services.fileprocessing.impl.FileWriterImpl;
import core.basesyntax.services.fileprocessing.impl.ReaderCsvImpl;
import core.basesyntax.services.fileprocessing.impl.ReportGeneratorImpl;
import core.basesyntax.services.fileprocessing.impl.TransactionGetterImpl;
import core.basesyntax.services.handlers.OperationHandler;
import core.basesyntax.services.handlers.impl.BalanceOperationHandler;
import core.basesyntax.services.handlers.impl.PurchaseOperationHandler;
import core.basesyntax.services.handlers.impl.ReturnOperationHandler;
import core.basesyntax.services.handlers.impl.SupplyOperationHandler;
import core.basesyntax.services.impl.FruitTransactionParserImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitService {
    private static final String PATH_TO_RAW_REPORT = "src/main/resources/SampleSourceCSV.csv";
    private static final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap =
            Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                    FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                    FruitTransaction.Operation.RETURN, new ReturnOperationHandler(),
                    FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
    private static List<String> rawData;
    private static DataSplitter dataSplitter;
    private static TransactionGetter transactionGetter;
    private static FruitTransactionParser fruitTransactionParser;
    private static OperationStrategy operationStrategy;
    private static FileWriter fileWriter;
    private static ReportGenerator reportGenerator;

    public static void initVars() {
        Reader reader = new ReaderCsvImpl();
        rawData = reader.readFile(PATH_TO_RAW_REPORT);
        dataSplitter = new DataSplitterImpl();
        transactionGetter = new TransactionGetterImpl();
        fruitTransactionParser = new FruitTransactionParserImpl();
        operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        fileWriter = new FileWriterImpl();
        reportGenerator = new ReportGeneratorImpl();
    }

    public static void processReport() {
        fruitTransactionParser.runOperationsOverFruit(
                transactionGetter.getTransactionsData(dataSplitter.divideData(rawData)),
                operationStrategy);
        fileWriter.writeToFile(reportGenerator.generateReport(Storage.getFruitsEntrySet()));
    }
}
