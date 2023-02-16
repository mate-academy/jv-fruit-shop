package core.basesyntax;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import core.basesyntax.impl.CsvFileReaderServiceImpl;
import core.basesyntax.impl.CsvFileReportWriterServiceImpl;
import core.basesyntax.impl.CsvReportServiceImpl;
import core.basesyntax.impl.CsvTransactionsParserParserImpl;
import core.basesyntax.impl.FruitShopServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationImpl.BalanceOperation;
import core.basesyntax.operationImpl.PurchaseOperation;
import core.basesyntax.operationImpl.ReturnOperation;
import core.basesyntax.operationImpl.SupplyOperation;
import core.basesyntax.operationStrategy.OperationHandler;
import core.basesyntax.operationStrategy.OperationStrategy;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.CsvReportService;
import core.basesyntax.service.CsvTransactionsParser;
import core.basesyntax.service.FruitShopService;

public class Main {
    private static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.now();
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH-mm");
    private static final String TO_FILE_PATH = "src/main/resources/report from " + LOCAL_DATE_TIME.format(DATE_TIME_FORMATTER) + ".csv";
    private static final String FROM_FILE_PATH = "src/main/resources/transactions.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        List<String> processedData = csvFileReaderService.readCsvFile(FROM_FILE_PATH);

        CsvTransactionsParser csvTransactionsParser = new CsvTransactionsParserParserImpl();
        List<FruitTransaction> fruitTransactionList =
                csvTransactionsParser.parseTransactions(processedData);

        OperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.transactionProcess(fruitTransactionList);

        CsvReportService csvReportService = new CsvReportServiceImpl();
        String report = csvReportService.getReport();

        CsvFileWriterService csvFileWriterService = new CsvFileReportWriterServiceImpl();
        csvFileWriterService.writeToFile(report, TO_FILE_PATH);
    }
}
