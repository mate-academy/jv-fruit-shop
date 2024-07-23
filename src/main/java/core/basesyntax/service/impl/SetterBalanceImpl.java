package core.basesyntax.service.impl;

import core.basesyntax.dao.ReportDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.SetterBalance;
import java.util.List;

public class SetterBalanceImpl implements SetterBalance {
    private final ReportDao reportDao;

    public SetterBalanceImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Override
    public void setBalance(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.stream()
                .filter(fruitTransaction -> fruitTransaction.getOperation() == Operation.BALANCE)
                .forEach(reportDao::updateReport);
    }
}
