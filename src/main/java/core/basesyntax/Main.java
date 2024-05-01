package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ReaderFromFile;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.WriterToFile;
import core.basesyntax.service.impl.ReaderFromFileImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriterToFileImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseHandlerImpl;
import core.basesyntax.strategy.impl.ReturnHandlerImpl;
import core.basesyntax.strategy.impl.SupplyHandlerImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FRUIT_SHOP_FILE_NAME = "src\\main\\resources\\During the day.csv";
    private static final String REPORT_FILE_NAME = "src\\main\\resources\\Report file.csv";

    public static void main(String[] args) {
        ReaderFromFile readerFromFile = new ReaderFromFileImpl();
        List<String> dataFromFile = readerFromFile.readFile(FRUIT_SHOP_FILE_NAME);

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactions = transactionParser.parseData(dataFromFile);

        OperationStrategy operationStrategy = new OperationStrategy(Map.of(
                Operation.BALANCE, new BalanceHandlerImpl(),
                Operation.SUPPLY, new SupplyHandlerImpl(),
                Operation.PURCHASE, new PurchaseHandlerImpl(),
                Operation.RETURN, new ReturnHandlerImpl()));

        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(operationStrategy);
        transactionProcessor.process(fruitTransactions);

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();

        WriterToFile writerToFile = new WriterToFileImpl();
        writerToFile.writeReportToFile(report, REPORT_FILE_NAME);
    }
}
