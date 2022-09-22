package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WriterServiceImpl implements WriterService {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public List<String> writeToFile() {
        return fruitDao.getStorage().entrySet()
                .stream()
                .map(this::getFromMap)
                .collect(Collectors.toList());
    }

    private String getFromMap(Map.Entry<Fruit, Integer> set) {
        String fruit = set.getKey().toString().toLowerCase();
        String quantity = set.getValue().toString();
        return fruit + "," + quantity;
    }
}
