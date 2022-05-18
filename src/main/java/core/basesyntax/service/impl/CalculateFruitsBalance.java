package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.CalculateBalance;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateFruitsBalance implements CalculateBalance {
    @Override
    public Map<String, Integer> getBalance() {
        return new StorageDaoImpl().getTransactions().stream()
                .collect(Collectors.groupingBy(t -> t.getProduct().getName(),
                        Collectors.summingInt(Transaction::getAmountByOperation)));
    }
}
