package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionHandlerImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE = "src/main/resources/source.csv";
    private static final String OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        TransactionHandler transactionHandler = new TransactionHandlerImpl(operationStrategy);

        CsvFileReader csvFileReader = new CsvFileReaderImpl(SOURCE_FILE);
        List<String> stringTransactionsList = csvFileReader.read();

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactions = transactionParser
                .parseTransactions(stringTransactionsList);

        transactionHandler.handleTransactions(fruitTransactions);

        ReportService reportService = new ReportServiceImpl(FruitStorage.storage);

        CsvFileWriter csvFileWriter = new CsvFileWriterImpl(OUTPUT_FILE);
        csvFileWriter.write(reportService.getReport());
    }
}
