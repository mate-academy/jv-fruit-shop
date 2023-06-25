import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FilesParser;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.FilesParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionHandlerImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_PATH = "src/main/java/resources/FromFile.csv";
    private static final String TO_FILE_PATH = "src/main/java/resources/ToFile.csv";

    public static void main(String[] args) {
        ReaderService readerService = new CsvFileReaderServiceImpl();
        List<String> data = readerService.readDataFromTheFile(FROM_FILE_PATH);
        FilesParser filesParser = new FilesParserImpl();
        final List<FruitTransaction> transactions = filesParser.parseFruitTransaction(data);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        TransactionHandler transactionHandler
                = new TransactionHandlerImpl(new FruitsDaoImpl(),operationStrategy);
        transactionHandler.applyTransactions(transactions);
        ReportGenerator generatedReport = new ReportGeneratorImpl();
        String reportFruitShop = generatedReport.getDataForReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeReportToFile(TO_FILE_PATH, reportFruitShop);
    }
}
