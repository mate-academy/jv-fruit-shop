package core.basesyntax.model;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

import java.util.Map;

public class OperationHandlerImpl implements OperationHandler {
    FruitDao fruitDao = new FruitDaoImpl(); // TODO: 02.07.2021

    @Override
    public void processRequest(String operation, String fruitName, int fruitQuantity) {
        switch (operation.toLowerCase()) {
            case ("b"):
                fruitDao.put(fruitName, fruitQuantity);
                break;
            case ("p"):
                int currentQuantity1 = fruitDao.getQuantity(fruitName);
                if (currentQuantity1 < fruitQuantity) {
                    throw new RuntimeException("Мы не можем продать товар, которого у нас нет");
                }
                fruitDao.put(fruitName, currentQuantity1 - fruitQuantity);
                break;
            case ("s"):
            case ("r"):
                int currentQuantity2 = fruitDao.getQuantity(fruitName);
                fruitDao.put(fruitName, currentQuantity2 + fruitQuantity);
                break;
        }
    }

    @Override
    public String getCurrentStorageState() {
        StringBuilder currentStorageState = new StringBuilder();
        currentStorageState.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> pair : fruitDao.getSet()) {
            currentStorageState.append(pair.getKey())
                    .append(",")
                    .append(pair.getValue())
                    .append("\n");
        }
        return currentStorageState.toString();
    }
}

