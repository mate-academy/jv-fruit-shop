package shopservice;

import fruitsassortment.Fruit;
import java.util.List;
import java.util.Map;
import shopdao.FruitDao;
import shopoperations.ListOfOperations;
import shopstrategy.Strategy;

public class StoreServiceImpl implements StoreService {
    private static final int OPERATION_TYPE = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int DATA_START_INDEX = 1;
    private static final String SEPARATOR = ",";
    private final Strategy operationStrategy;
    private final FruitDao fruitDao;

    public StoreServiceImpl(Strategy operationStrategy, FruitDao fruitDao) {
        this.operationStrategy = operationStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public boolean addToStorage(List<String> dataFromFile) {
        for (int i = DATA_START_INDEX; i < dataFromFile.size(); i++) {
            String[] data = dataFromFile.get(i).split(SEPARATOR);
            Fruit fruit = new Fruit(data[PRODUCT_NAME_INDEX]);
            int previousAmount = fruitDao.get(fruit);
            int newAmount = operationStrategy.get(ListOfOperations
                    .valueOf(data[OPERATION_TYPE].toUpperCase()))
                    .calculate(previousAmount, Integer.parseInt(data[AMOUNT_INDEX]));
            fruitDao.add(fruit, newAmount);
        }
        return true;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder().append("fruit,amount");
        Map<Fruit, Integer> products = fruitDao.getAll();
        for (Map.Entry<Fruit, Integer> productsEntry : products.entrySet()) {
            report.append(System.lineSeparator())
                    .append(productsEntry.getKey().getName())
                    .append(SEPARATOR)
                    .append(productsEntry.getValue());
        }
        return report.toString();
    }
}
