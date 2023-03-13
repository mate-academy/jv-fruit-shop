package service;

import dao.FruitDao;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitStore;

public class FruitStoreServiceImpl implements FruitStoreService {
    private static final String SEPARATOR = ",";
    private FruitDao fruitDao;
    private ActivitiesStrategy strategy;
    private FruitStore fruitStore;

    public FruitStoreServiceImpl(FruitDao fruitDao,
                                 ActivitiesStrategy strategy,
                                 FruitStore fruitStore) {
        this.fruitDao = fruitDao;
        this.strategy = strategy;
        this.fruitStore = fruitStore;
    }

    @Override
    public void generateReport() {
        Map<String, Integer> supplies = fruitStore.getSupplies();
        String report = supplies.entrySet()
                .stream()
                .map(entry -> entry.getKey()
                        + SEPARATOR
                        + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator(),
                        "fruit,quantity" + System.lineSeparator(),
                        ""));
        fruitDao.add(report);
    }

    @Override
    public void processInputData() {
        List<String> inputData = fruitDao.get();
        inputData.remove(0);
        for (String line : inputData) {
            String[] data = line.split(SEPARATOR);
            if (fruitStore.getSupplies().containsKey(data[1])) {
                int amount = strategy.get(data[0]).operation(Integer.valueOf(data[2]))
                        + fruitStore.getSupplies().get(data[1]);
                fruitStore.getSupplies().replace(data[1], amount);
            } else {
                fruitStore.getSupplies().put(data[1], Integer.valueOf(data[2]));
            }
        }
    }
}
