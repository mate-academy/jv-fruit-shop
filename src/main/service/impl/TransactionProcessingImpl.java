package main.service.impl;

import main.dao.ReportDao;
import main.model.Product;
import main.model.Transaction;
import main.service.TransactionProcessing;
import main.service.transaction.TransactionHandler;
import main.strategy.TransactionStrategy;

public class TransactionProcessingImpl implements TransactionProcessing {
    private TransactionStrategy transactionStrategy;
    private ReportDao reportDao;

    public TransactionProcessingImpl(TransactionStrategy transactionStrategy, ReportDao reportDao) {
        this.transactionStrategy = transactionStrategy;
        this.reportDao = reportDao;
    }

    @Override
    public void perform(Product product) {
        if (product.getTransaction() == Transaction.BALANCE) {
            return;
        }
        TransactionHandler transactionHandler = transactionStrategy.get(product.getTransaction());
        int balanceBeforeTransaction = reportDao.getBalanceForProduct(product);
        int balanceAfterTransaction = transactionHandler.perform(balanceBeforeTransaction, product.getQuantity());
        product.setQuantity(balanceAfterTransaction);
        reportDao.update(product);
    }
}
