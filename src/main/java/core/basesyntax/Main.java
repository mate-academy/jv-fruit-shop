package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.Transaction;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.FinalReport;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.StrategyProviderImpl;
import core.basesyntax.service.impl.TransactionImpl;
import core.basesyntax.service.impl.WriterToCsvImpl;
import core.basesyntax.strategy.OperationStrategyBalance;
import core.basesyntax.strategy.OperationStrategyPurchase;
import core.basesyntax.strategy.OperationStrategyReturn;
import core.basesyntax.strategy.OperationStrategySupply;
import java.util.List;

public class Main {
    private static final String DATA_FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        StrategyProviderImpl strategyProvider = new StrategyProviderImpl();
        strategyProvider.setStrategy(FruitTransaction.Operation.BALANCE,
                new OperationStrategyBalance());
        strategyProvider.setStrategy(FruitTransaction.Operation.PURCHASE,
                new OperationStrategyPurchase());
        strategyProvider.setStrategy(FruitTransaction.Operation.RETURN,
                new OperationStrategyReturn());
        strategyProvider.setStrategy(FruitTransaction.Operation.SUPPLY,
                new OperationStrategySupply());
        CsvFileReaderServiceImpl readerService = new CsvFileReaderServiceImpl();
        List<String> readFile = readerService.readFile(DATA_FILE_PATH);
        ParseService parseService = new ParseServiceImpl();
        List<FruitTransaction> transactions = parseService.fruitTransaction(readFile);
        Transaction transaction = new TransactionImpl();
        transaction.transaction(transactions, strategyProvider);
        FinalReport report = new FinalReport();
        List<String> reportToWrite = report.getReport();
        WriterToCsvImpl writer = new WriterToCsvImpl();
        writer.writeReport(REPORT_FILE_PATH, reportToWrite);
    }
}
