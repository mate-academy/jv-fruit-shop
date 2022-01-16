package service;

import dao.FruitDao;
import java.util.Map;
import model.Fruit;

public class ReportCreateService {
    private static final String SEPARATING_ELEMENT = ",";
    private static final String TITLE = "fruit,quantity";
    private FruitDao fruitDao;

    public ReportCreateService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(TITLE).append(System.lineSeparator());
        Map<Fruit, Integer> fruitDataBase = fruitDao.getAll();
        for (Map.Entry<Fruit, Integer> fruit : fruitDataBase.entrySet()) {
            builder.append(fruit.getKey().getFruitType())
                    .append(SEPARATING_ELEMENT)
                    .append(fruit.getValue()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
