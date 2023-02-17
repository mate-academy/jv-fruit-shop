package core.basesyntax;

import core.basesyntax.impl.CsvFileValidationImpl;
import core.basesyntax.impl.CsvTransactionsParserImpl;
import core.basesyntax.impl.FileReaderServiceImpl;
import core.basesyntax.impl.FileWriterServiceImpl;
import core.basesyntax.impl.FruitShopServiceImpl;
import core.basesyntax.impl.ReportInInCsvServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.service.CsvTransactionsParser;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileValidation;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportInCsvService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.now();
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH-mm");
    private static final String TO_FILE_PATH = "src/main/resources/report from "
            + LOCAL_DATE_TIME.format(DATE_TIME_FORMATTER) + ".csv";
    private static final String FROM_FILE_PATH = "src/main/resources/transactions.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        FileValidation fileValidation = new CsvFileValidationImpl();
        fileValidation.validateFile(FROM_FILE_PATH);

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> processedData = fileReaderService.readCsvFile(FROM_FILE_PATH);

        CsvTransactionsParser csvTransactionsParser = new CsvTransactionsParserImpl();
        List<FruitTransaction> fruitTransactionList =
                csvTransactionsParser.parseTransactions(processedData);

        OperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.transactionProcess(fruitTransactionList);

        ReportInCsvService reportInCsvService = new ReportInInCsvServiceImpl();
        String report = reportInCsvService.getReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, TO_FILE_PATH);
    }
}
