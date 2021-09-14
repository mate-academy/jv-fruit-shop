package shop.service;

import dao.FruitDao;
import shop.item.Fruit;

public class ShopServiceImpl implements ShopService {
    public static final String CSV_SEPARATOR = ",";
    private FruitDao fruitDao;
    private OperationsStrategy operationsStrategy;

    public ShopServiceImpl(FruitDao fruitDao, OperationsStrategy operationsStrategy) {
        this.fruitDao = fruitDao;
        this.operationsStrategy = operationsStrategy;
    }

    @Override
    public void saveToStorage(String[] linesFromFile) {
        for (int i = 1; i < linesFromFile.length; i++) {
            String[] operationNameQuality = linesFromFile[i].split(CSV_SEPARATOR);
            String operation = operationNameQuality[0];
            String fruitName = operationNameQuality[1];
            int quantity = Integer.parseInt(operationNameQuality[2]);
            operationsStrategy.get(operation).apply(new Fruit(fruitName, quantity));
        }
    }

    public void printReport() {
        System.out.println("fruit,quantity");
        for (Fruit fruit : fruitDao.getAll()) {
            System.out.println(fruit.getName() + CSV_SEPARATOR + fruit.getQuality());
        }
    }
}
