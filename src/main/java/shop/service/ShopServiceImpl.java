package shop.service;

import dao.FruitDao;
import shop.item.Fruit;

public class ShopServiceImpl implements ShopService {
    private static final String CSV_SEPARATOR = ",";
    private FruitDao fruitDao;
    private OperationsStrategy operationsStrategy;

    public ShopServiceImpl(FruitDao fruitDao, OperationsStrategy operationsStrategy) {
        this.fruitDao = fruitDao;
        this.operationsStrategy = operationsStrategy;
    }

    @Override
    public void fromFileToStorage(String[] linesFromFile) {
        for (String lines : linesFromFile) {
            String[] operationNameQuality = lines.split(CSV_SEPARATOR);
            String operation = operationNameQuality[0];
            String fruitName = operationNameQuality[1];
            int quantity = Integer.parseInt(operationNameQuality[2]);
            operationsStrategy.get(operation).operation(new Fruit(fruitName, quantity));
        }
    }

    public void printReport() {
        for (Fruit fruit : fruitDao.getAll()) {
            System.out.println(fruit.getName() + " " + fruit.getQuality());
        }
    }
}
