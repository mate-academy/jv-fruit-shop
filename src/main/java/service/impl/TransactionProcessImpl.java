package service.impl;

import dao.ReportDao;
import model.Fruit;
import model.Transaction;
import service.TransactionProcess;
import service.transaction.HandlerTransaction;
import strategy.StrategyTransaction;

public class TransactionProcessImpl implements TransactionProcess {
    private StrategyTransaction strategyTransaction;
    private ReportDao reportDao;

    public TransactionProcessImpl(StrategyTransaction strategyTransaction, ReportDao reportDao) {
        this.strategyTransaction = strategyTransaction;
        this.reportDao = reportDao;
    }

    @Override
    public void processPerform(Fruit fruit) {
        if (fruit.getTransaction() == Transaction.BALANCE) {
            return;
        }

        HandlerTransaction handlerTransaction = strategyTransaction
                .get(fruit.getTransaction());
        int balanceBeforeTransaction = reportDao.getBalanceFruit(fruit);
        int balanceAfterTransaction = handlerTransaction
                .perform(balanceBeforeTransaction, fruit.getQuantity());
        fruit.setQuantity(balanceAfterTransaction);
        reportDao.updateReport(fruit);
    }
}
