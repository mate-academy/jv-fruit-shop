package core.basesyntax.service.implemantation;

import core.basesyntax.service.SaveToStorageService;
import core.basesyntax.service.strategy.TransactionStrategy;
import java.util.List;

public class SaveToStorageImpl implements SaveToStorageService {
    public static final int OPERATION_TYPE_INDEX = 0;
    public static final String COMA_SEPARATOR = ",";
    public static final int HEADER_OF_INPUT_FILE_INDEX = 1;
    private TransactionStrategy transactionStrategy;

    public SaveToStorageImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
  public void storeAll(List<String> linesFromFile) {
        linesFromFile.stream()
        .skip(HEADER_OF_INPUT_FILE_INDEX)
        .map(s -> s.split(COMA_SEPARATOR))
                .forEach(a -> transactionStrategy.get(a[OPERATION_TYPE_INDEX]).store(a));
    }
}
