package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageRecordsSetter;
import core.basesyntax.dao.impl.StorageRecordsSetterImpl;
import core.basesyntax.function.impl.StringToTransactionConverter;
import core.basesyntax.function.impl.TransactionCalculator;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.BalanceCalculatorService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BalanceCalculatorServiceImpl implements BalanceCalculatorService {
    public static final int INDEX_TITLE = 0;

    private static final StringToTransactionConverter stringToTransactionConverter
            = new StringToTransactionConverter();
    private static final TransactionCalculator transactionCalculator
            = new TransactionCalculator();
    private static final StorageRecordsSetter storageRecordsSetter
            = new StorageRecordsSetterImpl();

    @Override
    public void calculate(List<String> strings) {
        strings.remove(INDEX_TITLE);
        List<FruitTransaction> transactions = strings.stream()
                .map(stringToTransactionConverter)
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
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value < 0) {
                throw new RuntimeException("Something wrong with balance for " + key
                        + "\n It is negative.");
            }
        }
        storageRecordsSetter.set(balance);
    }
}
