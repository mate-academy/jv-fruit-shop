package core.basesyntax.service.implemantation;

import core.basesyntax.service.SaveToStorageService;
import core.basesyntax.service.strategy.TransactionStrategy;
import java.util.List;

public class SaveToStorageImpl implements SaveToStorageService {
    public static final int OPERATION_TYPE_INDEX = 0;
    public static final String COMA_SEPARATOR = ",";
    private TransactionStrategy transactionStrategy;

    public SaveToStorageImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
  public void storeAll(List<String> linesFromFile) {
        linesFromFile.stream()
        .skip(1)
        .map(s -> s.split(COMA_SEPARATOR))
                .forEach(a -> transactionStrategy.get(a[OPERATION_TYPE_INDEX]).store(a));
    }
}
