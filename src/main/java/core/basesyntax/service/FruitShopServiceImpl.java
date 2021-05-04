package core.basesyntax.service;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.handler.OperationHandler;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String DEFAULT_START = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private FruitShopDao fruitShopDao;
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl(FruitShopDao fruitShopDao, OperationStrategy operationStrategy) {
        this.fruitShopDao = fruitShopDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void saveData(List<String> data) {
        for (int i = 1; i < data.size(); i++) {
            String[] dataFromList = data.get(i).split(COMMA);
            Fruit fruit = new Fruit(dataFromList[INDEX_OF_FRUIT]);
            int quantity = Integer.parseInt(dataFromList[INDEX_OF_QUANTITY]);
            if (quantity < 0) {
                throw new RuntimeException("Invalid quantity");
            }
            int currentQuantity = fruitShopDao.getBalance(fruit);
            OperationHandler operationHandler = operationStrategy
                    .get(dataFromList[INDEX_OF_OPERATION_TYPE])
                    .orElseThrow(() -> new RuntimeException("Invalid operation type"));
            int updatedQuantity = operationHandler.updateQuantity(currentQuantity, quantity);
            fruitShopDao.add(fruit, updatedQuantity);
        }
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder().append(DEFAULT_START);
        Map<Fruit, Integer> fruitMap = fruitShopDao.getAll();
        stringBuilder.append(fruitMap.entrySet().stream()
                .map(entry -> entry.getKey().getName() + COMMA + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator())));
        return stringBuilder.toString();
    }
}
