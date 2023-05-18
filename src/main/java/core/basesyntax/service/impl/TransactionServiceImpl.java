package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.TransactionStrategy;
import core.basesyntax.service.TransactionStrategyImpl;
import core.basesyntax.service.transaction.BalanceTransactionHandler;
import core.basesyntax.service.transaction.PurchaseTransactionHandler;
import core.basesyntax.service.transaction.ReturnTransactionHandler;
import core.basesyntax.service.transaction.SupplyTransactionHandler;
import core.basesyntax.service.transaction.TransactionHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private HashMap<FruitTransaction.Operation, TransactionHandler> operationMap;

    public TransactionServiceImpl() {
        operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler());
        operationMap.put(FruitTransaction.Operation.RETURN, new ReturnTransactionHandler());
    }

    @Override
    public FruitTransaction createTransaction(String line) {
        String[] data = line.split(",");
        return new FruitTransaction(
                FruitTransaction.Operation.valueOfCode(data[OPERATION_INDEX]),
                data[FRUIT_NAME_INDEX],
                Integer.parseInt(data[AMOUNT_INDEX]));
    }

    @Override
    public List<FruitTransaction> getListOfTransactionsFromString(String transactions) {
        List<FruitTransaction> list = new ArrayList<>();
        String[] lines = transactions.split(System.lineSeparator());
        for (String line: lines) {
            list.add(createTransaction(line));
        }
        return list;
    }

    @Override
    public void processAllTransactions(List<FruitTransaction> transactions) {
        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(operationMap);
        for (FruitTransaction transaction: transactions) {
            TransactionHandler handler = transactionStrategy.getHandler(transaction.getOperation());
            handler.handle(transaction);
        }
    }
}
