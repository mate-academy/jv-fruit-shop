package core;

import core.dao.StorageDao;
import core.dao.StorageDaoImpl;
import core.operations.BalanceOperation;
import core.operations.Operation;
import core.operations.PurchaseOperation;
import core.operations.ReturnOperation;
import core.operations.SupplyOperation;
import core.storage.Storage;
import core.storage.StorageImpl;
import core.strategy.OperationStrategyImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    private static final String READ_FROM_FILE_NAME = "src/main/resources/operations.csv";
    private static final String WRITE_TO_FILE_NAME = "src/main/resources/report.csv";
    private static final String CHAR_FOR_SPLIT = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_COUNT = 2;

    public static void main(String[] args) {
        Map<FruitTransaction.Activity, Operation> activityOperationMap = createHashMap();
        Storage storage = new StorageImpl();
        StorageDao storageDao = new StorageDaoImpl();

        storageDao.readData(READ_FROM_FILE_NAME)
                .stream()
                .map(s -> s.split(CHAR_FOR_SPLIT))
                .map(strings -> new FruitTransaction(Arrays.stream(FruitTransaction
                                .Activity.values())
                        .filter(o -> o.getOperation().equals(strings[INDEX_OPERATION]))
                        .findFirst()
                        .get(),
                        strings[INDEX_FRUIT],
                        Integer.parseInt(strings[INDEX_COUNT])))
                        .forEach(new Consumer<FruitTransaction>() {
                            @Override
                            public void accept(FruitTransaction fruitTransaction) {
                                new OperationStrategyImpl(activityOperationMap)
                                        .get(fruitTransaction.getActivity())
                                        .performOperation(storage, fruitTransaction);
                            }
                        });
        storageDao.writeData(WRITE_TO_FILE_NAME, storageToCsvData(storage));
    }

    private static Map<FruitTransaction.Activity, Operation> createHashMap() {
        Map<FruitTransaction.Activity, Operation> activityOperationMap = new HashMap<>();
        activityOperationMap.put(FruitTransaction.Activity.BALANCE, new BalanceOperation());
        activityOperationMap.put(FruitTransaction.Activity.PURCHASE, new PurchaseOperation());
        activityOperationMap.put(FruitTransaction.Activity.RETURN, new ReturnOperation());
        activityOperationMap.put(FruitTransaction.Activity.SUPPLY, new SupplyOperation());
        return activityOperationMap;
    }

    private static String storageToCsvData(Storage storage) {
        return storage.getAllData()
                .entrySet()
                .stream()
                .map(stringIntegerEntry -> stringIntegerEntry.getKey() + CHAR_FOR_SPLIT
                        + stringIntegerEntry.getValue())
                .collect(Collectors.joining(System.getProperty("line.separator")));
    }
}
