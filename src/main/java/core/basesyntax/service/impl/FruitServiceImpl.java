package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.FruitService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String COMMA = ",";
    private final FruitDao<String, Integer> fruitDao;
    private final String pathToReport;

    public FruitServiceImpl(FruitDao<String, Integer> fruitDao, String pathToReport) {
        this.fruitDao = fruitDao;
        this.pathToReport = pathToReport;
    }

    @Override
    public boolean balance(String fruitName, int quantity) {
        fruitDao.addStorage(fruitName, quantity);
        return true;
    }

    @Override
    public boolean supplyFruit(String fruitName, int quantity) {

        fruitDao.addStorage(fruitName, quantity);
        return true;
    }

    @Override
    public boolean purchaseFruit(String fruit, int quantity) {
        fruitDao.removeFromStorage(fruit, quantity);
        return true;
    }

    @Override
    public boolean returnFruit(String fruit, int quantity) {
        fruitDao.addStorage(fruit, quantity);
        return true;
    }

    @Override
    public boolean createReport() {
        Map<String, Integer> setFruit = fruitDao.getAllFruits();
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        setFruit.forEach((fruitName, quantity) -> stringBuilder.append(fruitName)
                .append(COMMA).append(quantity).append(System.lineSeparator()));
        try {
            Files.writeString(Path.of(pathToReport), stringBuilder.toString());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
