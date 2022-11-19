package core.basesyntax;

import core.basesyntax.dao.FruitReportDao;
import core.basesyntax.dao.FruitReportDaoImpl;
import core.basesyntax.dao.FruitTransactionCsvParser;
import core.basesyntax.dao.FruitTransactionCsvParserImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitShopService;
import core.basesyntax.services.FruitShopServiceImpl;
import core.basesyntax.services.TransactionStrategy;
import core.basesyntax.services.TransactionStrategyImpl;
import core.basesyntax.services.transaction.BalanceOperationHandler;
import core.basesyntax.services.transaction.PurchaseOperationHandler;
import core.basesyntax.services.transaction.ReturnOperationHandler;
import core.basesyntax.services.transaction.SupplyOperationHandler;
import core.basesyntax.services.transaction.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String FRUIT_TRANSACTION_FILE_NAME = "src/main/resources/transactions.csv";
    private static final String FRUIT_REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> transactionMap = new HashMap<>();
        transactionMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        transactionMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        transactionMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        transactionMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        FruitTransactionCsvParser fruitTransactionDao = new FruitTransactionCsvParserImpl();
        List<FruitTransaction> parsedTransactions = fruitTransactionDao.parse(FRUIT_TRANSACTION_FILE_NAME);

        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(transactionMap);
        FruitShopService transactionService = new FruitShopServiceImpl(transactionStrategy);

        for (FruitTransaction transaction: parsedTransactions) {
            transactionService.doTransaction(transaction);
        }

        FruitReportDao fruitReportDao = new FruitReportDaoImpl();
        fruitReportDao.createReport(FRUIT_REPORT_FILE_NAME);
    }
}
