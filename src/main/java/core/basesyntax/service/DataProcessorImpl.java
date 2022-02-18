package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.Arrays;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final StorageDao storageDao = new StorageDaoImpl();
    private final OperationStrategy operationStrategy;

    public enum OperationType {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operation;

        OperationType(String operation) {
            this.operation = operation;
        }

        public String getStr() {
            return operation;
        }

        public static OperationType getType(String str) {
            return Arrays.stream(OperationType.values())
                    .filter(t -> t.getStr().equals(str))
                    .findFirst()
                    .get();
        }
    }

    public DataProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void registerTransaction(String line) {
        String[] transactionInfo = line.split(",");
        operationStrategy
                .get(OperationType.getType(transactionInfo[OPERATION_INDEX]))
                .performOperation(
                        transactionInfo[NAME_INDEX],
                        Integer.parseInt(transactionInfo[AMOUNT_INDEX]),
                        storageDao
                );
    }

    @Override
    public void createFruits(List<String> parsedData) {
        parsedData.stream()
                .filter(l -> l.startsWith("b")
                        || l.startsWith("s")
                        || l.startsWith("p")
                        || l.startsWith("r"))
                .forEach(this::registerTransaction);
    }
}
