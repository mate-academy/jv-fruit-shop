package core.basesyntax;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.StorageDao;
import core.basesyntax.model.impl.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportProvider;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FruitTransactionParser;
import core.basesyntax.service.impl.FruitTransactionProcessor;
import core.basesyntax.service.impl.ReportProviderImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.strategy.BalanceOperationHandler;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.PurchaseOperationHandler;
import core.basesyntax.service.strategy.ReturnOperationHandler;
import core.basesyntax.service.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class MainApp {
    private static final String SOURCE_REPORT_NAME = "src/main/resources/report.csv";
    private static final String RESULT_REPORT_NAME = "src/main/resources/new-report";

    public static void main(String[] args) {
        generateReport(SOURCE_REPORT_NAME, RESULT_REPORT_NAME);
    }

    private static void generateReport(String sourceReportName, String newReportName) {
        FileReader fileReader = new FileReaderImpl();
        TransactionParser<FruitTransaction> transactionParser
                = new FruitTransactionParser();
        TransactionProcessor<FruitTransaction> transactionProcessor
                = new FruitTransactionProcessor(initOperationStrategy());
        fileReader.read(sourceReportName)
                .stream()
                .map(transactionParser::parse)
                .forEach(transactionProcessor::process);
        ReportProvider provider = new ReportProviderImpl();
        FileWriter writer = new WriterServiceImpl();
        writer.write(provider.provide(), newReportName);
        StorageDao.storage.clear();
    }

    private static OperationStrategy<FruitTransaction> initOperationStrategy() {
        Map<OperationType, OperationHandler<FruitTransaction>> strategyMap = new HashMap<>();
        strategyMap.put(OperationType.BALANCE, new BalanceOperationHandler());
        strategyMap.put(OperationType.RETURN, new ReturnOperationHandler());
        strategyMap.put(OperationType.SUPPLY, new SupplyOperationHandler());
        strategyMap.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        return new OperationStrategyImpl(strategyMap);
    }
}
