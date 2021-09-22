package service.storage;

import dao.FruitsDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Fruit;
import service.parsing.Parsing;
import service.parsing.ParsingImpl;
import strategy.OperationStrategy;

public class StoreServiceImpl implements StoreService {
    private static OperationStrategy operationStrategy;
    private static FruitsDao fruitsDao;
    private static final String TITLE = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int VALUE_INDEX = 2;

    public StoreServiceImpl(OperationStrategy operationStrategy, FruitsDao fruitsDao) {
        this.operationStrategy = operationStrategy;
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void applyToDb(List<String> dataFromFile) {
        Parsing parsing = new ParsingImpl();
        for (int i = 0; i < dataFromFile.size(); i++) {
            String[] data = parsing.parsing(dataFromFile.get(i));
            Fruit operationFruit =
                    new Fruit(Fruit.OperationType.get(data[OPERATION_INDEX]),
                            data[FRUIT_INDEX],
                            Integer.parseInt(data[VALUE_INDEX]));

            int oldValue = fruitsDao.get(operationFruit);

            int value = Integer.parseInt(data[VALUE_INDEX]);

            String operationType = String.valueOf(Fruit.OperationType.get(data[OPERATION_INDEX]));
            if (!Fruit.contains(operationType)) {
                throw new RuntimeException("Incorrect operation " + operationType);
            }
            int newValue = operationStrategy
                    .get(Fruit.OperationType.valueOf(operationType))
                    .calculateValue(oldValue, value);

            fruitsDao.save(operationFruit, newValue);
        }
    }

    @Override
    public String getDbReport() {
        List<String> data = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE);
        Map<Fruit, Integer> operationMap = fruitsDao.getAll();
        for (Map.Entry<Fruit, Integer> entry : operationMap.entrySet()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(entry.getKey().getFruitName()
                    + CSV_SEPARATOR + entry.getValue());
        }
        return stringBuilder.toString();
    }
}
