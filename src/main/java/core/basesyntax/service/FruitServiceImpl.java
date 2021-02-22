package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static Map<String, Fruit.Type> mapOfFruitTypes = fillMapOfFruitTypes();
    private FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public Fruit createNewFruit(String fruitName, int amount) {
        Fruit fruit = new Fruit();
        fruit.setName(fruitName);
        fruit.setAmount(amount);
        return fruit;
    }

    @Override
    public List<Fruit> getAllFruitFromFile(String fileName) {
        List<String> records = new ArrayList<>();
        try {
            records = Files.readAllLines(Path.of(fileName));
            records.remove(0); // remove the record with title
        } catch (IOException e) {
            throw new RuntimeException("Can`t get data from file " + fileName);
        }
        return records.stream()
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private Fruit getFromCsvRow(String line) {
        String[] words = line.trim().split(",");
        Fruit fruit = new Fruit();
        fruit.setName(words[1]);
        fruit.setAmount(Integer.valueOf(words[2]));
        fruit.setType(mapOfFruitTypes.get(words[0]));
        return fruit;
    }

    private static Map<String, Fruit.Type> fillMapOfFruitTypes() {
        Map<String, Fruit.Type> map = new HashMap<>();
        map.put("b", Fruit.Type.BALANCE);
        map.put("p", Fruit.Type.PURCHASE);
        map.put("s", Fruit.Type.SUPPLY);
        map.put("r", Fruit.Type.RETURN);
        return map;
    }
}
