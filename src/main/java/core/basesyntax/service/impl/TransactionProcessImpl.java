package core.basesyntax.service.impl;

import core.basesyntax.dao.ReportDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionProcess;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;

public class TransactionProcessImpl implements TransactionProcess {
    private final ReportDao reportDao;
    private OperationStrategy operationStrategy;

    public TransactionProcessImpl(OperationStrategy operationStrategy, ReportDao reportDao) {
        this.reportDao = reportDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getOperation() == Operation.BALANCE) {
            return;
        }
        OperationHandler operationHandler = operationStrategy
                .operationHandler(fruitTransaction.getOperation());
        int balanceBefore = reportDao.getBalanceFruitTransaction(fruitTransaction);
        int balanceAfter = operationHandler
                .warehouse(balanceBefore, fruitTransaction.getQuantity());
        fruitTransaction.setQuantity(balanceAfter);
        reportDao.updateReport(fruitTransaction);
    }
}
