package core.basesyntax.service.impl;

import core.basesyntax.dao.ReportDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionProcess;
import core.basesyntax.strategy.StrategyFruitTransaction;
import core.basesyntax.transaction.OperationHandler;

public class TransactionProcessImpl implements TransactionProcess {
    private final StrategyFruitTransaction strategyFruitTransaction;
    private final ReportDao reportDao;

    public TransactionProcessImpl(StrategyFruitTransaction strategyFruitTransaction,
                                  ReportDao reportDao) {
        this.strategyFruitTransaction = strategyFruitTransaction;
        this.reportDao = reportDao;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getOperation() == Operation.BALANCE) {
            return;
        }
        OperationHandler operationHandler = strategyFruitTransaction
                .execute(fruitTransaction.getOperation());
        int balanceBeforeOperation = reportDao
                .getBalanceFruitTransaction(fruitTransaction);
        int balanceAfterOperation = operationHandler
                .perform(balanceBeforeOperation, fruitTransaction.getQuantity());
        fruitTransaction.setQuantity(balanceAfterOperation);
        reportDao.updateReport(fruitTransaction);
    }
}
