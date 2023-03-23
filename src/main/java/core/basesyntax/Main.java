package core.basesyntax;

import core.basesyntax.dao.TransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.filereader.FileParserImpl;
import core.basesyntax.service.filereader.FileReaderImpl;
import core.basesyntax.service.filewriter.FileWriterImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.interfaces.strategy.TransactionStrategy;
import core.basesyntax.service.transactions.PurchaseTransactionHandler;
import core.basesyntax.service.transactions.ReturnTransactionHandler;
import core.basesyntax.service.transactions.SupplyTransactionHandler;
import core.basesyntax.service.transactions.TransactionStrategyImpl;
import core.basesyntax.service.transactions.BalanceTransactionHandler;

public class Main {
    static final String INPUT_FILE = "src/main/resources/input.csv";
    static final String REPORT_FILE = "src/main/resources/report.csv";
    static final ReportService FRUIT_SHOP_SERVICE = new ReportServiceImpl(new TransactionDaoImpl(),
            new FileReaderImpl(), new FileParserImpl(),
            new FileWriterImpl());
    static final TransactionStrategy TRANSACTION_STRATEGY = new TransactionStrategyImpl();

    public static void main(String[] args) {
        TRANSACTION_STRATEGY.addToMap(FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler());
        TRANSACTION_STRATEGY.addToMap(FruitTransaction.Operation.RETURN, new ReturnTransactionHandler());
        TRANSACTION_STRATEGY.addToMap(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler());
        TRANSACTION_STRATEGY.addToMap(FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler());

        FRUIT_SHOP_SERVICE.createReport(INPUT_FILE,REPORT_FILE);
    }
}
