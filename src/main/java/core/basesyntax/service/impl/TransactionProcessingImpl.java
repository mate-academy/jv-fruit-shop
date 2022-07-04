package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionProcessing;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceTransactionImpl;
import core.basesyntax.strategy.impl.PurchaseTransactionImpl;
import core.basesyntax.strategy.impl.ReturnTransactionImpl;
import java.util.List;

public class TransactionProcessingImpl implements TransactionProcessing {
    private static final int FRUIT_TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public void transactionProcessing(List<String> transactionsList) {
        for (int i = 1; i < transactionsList.size(); i++) {
            String[] arrayOfList = transactionsList.get(i).split(",");
            if (arrayOfList[FRUIT_TRANSACTION_INDEX].equals(Transaction.BALANCE.getTransaction())) {
                FruitTransaction balance = new BalanceTransactionImpl();
                balance.getTransaction(arrayOfList[FRUIT_INDEX],
                        Integer.parseInt(arrayOfList[FRUIT_QUANTITY_INDEX]));
            }
            if (arrayOfList[FRUIT_TRANSACTION_INDEX]
                    .equals(Transaction.PURCHASE.getTransaction())) {
                FruitTransaction purchase = new PurchaseTransactionImpl();
                purchase.getTransaction(arrayOfList[FRUIT_INDEX],
                        Integer.parseInt(arrayOfList[FRUIT_QUANTITY_INDEX]));
            }
            if (arrayOfList[FRUIT_TRANSACTION_INDEX].equals(Transaction.RETURN.getTransaction())) {
                FruitTransaction returnOperation = new ReturnTransactionImpl();
                returnOperation.getTransaction(arrayOfList[FRUIT_INDEX],
                        Integer.parseInt(arrayOfList[FRUIT_QUANTITY_INDEX]));
            }
            if (arrayOfList[FRUIT_TRANSACTION_INDEX].equals(Transaction.SUPPLY.getTransaction())) {
                FruitTransaction supply = new ReturnTransactionImpl();
                supply.getTransaction(arrayOfList[FRUIT_INDEX],
                        Integer.parseInt(arrayOfList[FRUIT_QUANTITY_INDEX]));
            }
        }
    }
}
