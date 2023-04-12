package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.function.impl.TransactionCalculator;
import core.basesyntax.function.impl.TransactionParser;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.BalanceCalculatorService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BalanceCalculatorServiceImpl implements BalanceCalculatorService {
    public static final int INDEX_TITLE = 0;

    private static final TransactionParser transactionParser
            = new TransactionParser();
    private static final TransactionCalculator transactionCalculator
            = new TransactionCalculator();
    private static final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void calculate(List<String> strings) {
        strings.remove(INDEX_TITLE);
        List<FruitTransaction> transactions = strings.stream()
                .map(transactionParser)
                .collect(Collectors.toList());
        Map<String,Integer> balance = transactions
                .stream()
                .map(transactionCalculator)
                         .flatMap(map -> map.entrySet().stream())
                         .collect(Collectors.toMap(
                                 Map.Entry::getKey,
                                 Map.Entry::getValue,
                                 Integer::sum
                         ));
        for (Map.Entry<String, Integer> entry : balance.entrySet()) {
            storageDao.add(entry.getKey(),entry.getValue());
        }
    }
}
