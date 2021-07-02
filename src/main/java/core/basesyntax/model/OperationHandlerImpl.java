package core.basesyntax.model;

import core.basesyntax.dao.FruitDao;
import java.util.Map;

public class OperationHandlerImpl implements OperationHandler {
    private static final String WORDS_SEPARATOR = ",";
    private static final String LINES_SEPARATOR = "\n";
    private final FruitDao fruitDao;

    public OperationHandlerImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

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
            default:
                throw new RuntimeException("Invalid operation: " + operation);
        }
    }

    @Override
    public String getCurrentStorageState() {
        StringBuilder currentStorageState = new StringBuilder();
        currentStorageState.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> pair : fruitDao.getSet()) {
            currentStorageState.append(pair.getKey())
                    .append(WORDS_SEPARATOR)
                    .append(pair.getValue())
                    .append(LINES_SEPARATOR);
        }
        return currentStorageState.toString();
    }
}

