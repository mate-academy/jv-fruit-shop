package service.impl;

import dao.FruitDao;
import java.util.List;
import model.FruitStore;
import service.ProcessData;
import strategy.ActivitiesStrategy;

public class ProcessDataImpl implements ProcessData {
    private static final int INDEX_OF_TITLE = 0;
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final String SEPARATOR = ",";
    private FruitDao fruitDao;
    private ActivitiesStrategy strategy;
    private FruitStore fruitStore;

    public ProcessDataImpl(FruitDao fruitDao, ActivitiesStrategy strategy, FruitStore fruitStore) {
        this.fruitDao = fruitDao;
        this.strategy = strategy;
        this.fruitStore = fruitStore;
    }

    @Override
    public void processInputData() {
        List<String> inputData = fruitDao.get();
        inputData.remove(INDEX_OF_TITLE);
        for (String line : inputData) {
            String[] data = line.split(SEPARATOR);
            if (fruitStore.getSupplies().containsKey(data[FRUIT_POSITION])) {
                int amount = strategy.get(data[OPERATION_POSITION].trim())
                        .operation(Integer.valueOf(data[QUANTITY_POSITION]))
                        + fruitStore.getSupplies().get(data[FRUIT_POSITION]);
                fruitStore.getSupplies().replace(data[FRUIT_POSITION], amount);
            } else {
                fruitStore.getSupplies().put(data[FRUIT_POSITION],
                        Integer.valueOf(data[QUANTITY_POSITION]));
            }
        }
    }
}
