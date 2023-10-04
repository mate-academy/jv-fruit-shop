package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvTransactionParserImpl;
import core.basesyntax.service.impl.FinalReport;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.List;

public class Main {
    private static final String DATA_FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        OperationStrategyImpl strategy = new OperationStrategyImpl();
        strategy.setStrategy(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitDao));
        strategy.setStrategy(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitDao));
        strategy.setStrategy(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitDao));
        strategy.setStrategy(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitDao));
        ReaderImpl readerService = new ReaderImpl();
        List<String> readFile = readerService.readFile(DATA_FILE_PATH);
        TransactionParser transactionParser = new CsvTransactionParserImpl();
        List<FruitTransaction> transactions = transactionParser.fruitTransaction(readFile);
        TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
        transactionProcessor.transaction(transactions, strategy);
        FinalReport report = new FinalReport();
        List<String> reportToWrite = report.getReport();
        WriterImpl writer = new WriterImpl();
        writer.writeReport(REPORT_FILE_PATH, reportToWrite);
    }
}
