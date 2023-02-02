package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.TransactionStrategyImpl;
import core.basesyntax.transaction.BalanceTransaction;
import core.basesyntax.transaction.PurchaseTransaction;
import core.basesyntax.transaction.ReturnTransaction;
import core.basesyntax.transaction.SupplyTransaction;
import core.basesyntax.transaction.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/resources/input.csv";
        Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap = new HashMap<>();
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceTransaction());
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyTransaction());
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnTransaction());
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransaction());

        ReaderService reader = new ReaderServiceImpl();
        List<FruitTransaction> transactionList = reader.read(filePath);
        TransactionService transactionService = new TransactionServiceImpl();
        TransactionStrategy transactionStrategy
                = new TransactionStrategyImpl(transactionHandlerMap);

        for (FruitTransaction transaction : transactionList) {
            transactionService.handleTransaction(
                    transactionStrategy.getHandler(transaction.getOperation()),
                    transaction.getFruit(),
                    transaction.getQuantity()
            );
        }

        String reportFilePath = "src/resources/report.csv";
        String report = (new ReportMakerServiceImpl()).makeReport();

        new WriterServiceImpl(reportFilePath).write(report);
    }
}
