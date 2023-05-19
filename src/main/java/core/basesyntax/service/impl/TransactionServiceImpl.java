package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.TransactionStrategy;
import core.basesyntax.service.transaction.TransactionHandler;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private TransactionStrategy transactionStrategy;

    public TransactionServiceImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public FruitTransaction createTransaction(String transactionString) {
        String[] data = transactionString.split(",");
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
        for (FruitTransaction transaction: transactions) {
            TransactionHandler handler = transactionStrategy.getHandler(transaction.getOperation());
            handler.handle(transaction);
        }
    }
}
