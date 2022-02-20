package core.basesyntax.service.impls;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.RecordStrategy;
import core.basesyntax.service.StoreService;
import core.basesyntax.service.handler.OperationHandler;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StoreServiceImpl implements StoreService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int START_DATA_INDEX = 1;
    private final FruitDao storeDao;
    private final RecordStrategy recordStrategy;

    public StoreServiceImpl(FruitDao storeDao, RecordStrategy recordStrategy) {
        this.storeDao = storeDao;
        this.recordStrategy = recordStrategy;
    }

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_TITLE).append(System.lineSeparator());
        Map<Fruit, Integer> fruitQuantityMap = storeDao.getAll();
        stringBuilder.append(fruitQuantityMap.entrySet().stream()
                .map(entry -> entry.getKey().getName() + CSV_SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator())));
        return stringBuilder.toString();
    }

    @Override
    public void processRecords(List<String> data) {
        for (int i = START_DATA_INDEX; i < data.size(); i++) {
            String[] currentOperationData = data.get(i).split(CSV_SEPARATOR);
            Fruit fruit = new Fruit(currentOperationData[FRUIT_NAME_INDEX]);
            int inputQuantity = Integer.parseInt(currentOperationData[QUANTITY_INDEX]);
            if (inputQuantity < 0) {
                throw new RuntimeException("Input data can't be negative!");
            }
            int currentQuantity = storeDao.get(fruit);
            OperationHandler operationHandler = recordStrategy
                    .get(currentOperationData[OPERATION_INDEX])
                    .orElseThrow(() -> new RuntimeException("Unknown operation: "
                            + currentOperationData[OPERATION_INDEX]));
            int newQuantity = operationHandler.calculateQuantity(currentQuantity, inputQuantity);
            storeDao.add(fruit, newQuantity);
        }
    }
}
