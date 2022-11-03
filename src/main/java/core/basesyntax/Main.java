package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.impl.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvReportGenerator;
import core.basesyntax.service.CsvTransactionParser;
import core.basesyntax.service.FIleWriter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.CsvReportGeneratorImpl;
import core.basesyntax.service.impl.CsvTransactionParserImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.impl.BalanceOperationHandler;
import core.basesyntax.service.operations.impl.PurchaseOperationHandler;
import core.basesyntax.service.operations.impl.ReturnOperationHandler;
import core.basesyntax.service.operations.impl.SupplyOprationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String CSV_FILE_PATH = "src/main/resources/data.csv";
    private static final String CSV_REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOprationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        //
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        FileReader fileReader = new FileReaderImpl();
        CsvTransactionParser csvTransactionParser = new CsvTransactionParserImpl();
        List<FruitTransaction> fruitTransactions = csvTransactionParser.csvParse(fileReader
                .readFile(CSV_FILE_PATH));
        TransactionService transactionService =
                new TransactionServiceImpl(operationStrategy, fruitStorageDao);
        transactionService.transaction(fruitTransactions);
        CsvReportGenerator csvReportGenerator = new CsvReportGeneratorImpl();
        byte[] csvReportBytes = csvReportGenerator.generateCsvReport(fruitStorageDao.getAll());
        FIleWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(CSV_REPORT_PATH, csvReportBytes);
    }
}
